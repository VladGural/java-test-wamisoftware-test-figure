package com.example.figure.calculate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Vladyslav Gural
 * @version 2024-12-09
 */
@Tag(name = "figure resources")
@RestController
@RequestMapping("/v1/figures")
class CalculateResource {
    private static final Logger logger = LoggerFactory.getLogger(CalculateResource.class);

    private final CalculateService service;

    CalculateResource(CalculateService service) {
        this.service = service;
    }

    @Operation(summary = "Calculate figure's prooerties")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Figure properties successfuly calculated"),
            @ApiResponse(responseCode = "400", description = "Request validation failed")
    })
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/properties")
    CalculateResponse calculateFigureProperties(@RequestBody @Valid CalculateRequest request) {
        logger.info("User try to calculate property of: {} figure", request.getFigureType());
        CalculateResponse response = service.calculateFigureProperties(request);
        logger.info("Successfully calculate: {} properties: {}", request.getFigureType(), response);
        return response;
    }
}
