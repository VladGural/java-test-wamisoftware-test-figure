package com.example.figure.calculate;

import com.example.figure.domain.FigureCalculateRequest;
import com.example.figure.domain.FigureCalculateResponse;
import com.example.figure.domain.FigureCalculateService;
import com.example.figure.figure.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Vladyslav Gural
 * @version 2024-12-09
 */
@Service
class CalculateService {
    private static final Logger logger = LoggerFactory.getLogger(CalculateResource.class);

    private final FigureHolder figureHolder;

    public CalculateService(FigureHolder figureHolder) {
        this.figureHolder = figureHolder;
    }

    FigureCalculateResponse calculateFigureProperties(FigureCalculateRequest request) {
        FigureCalculateService figureCalculateService = figureHolder.getFigureCalculateService(request.getFigureType());
        return figureCalculateService.calculate(request);
    }
}
