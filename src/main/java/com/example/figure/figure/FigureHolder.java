package com.example.figure.figure;

import com.example.figure.domain.FigureCalculateService;
import com.example.figure.domain.type.FigureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@Component
public class FigureHolder {
    private static final Logger logger = LoggerFactory.getLogger(FigureHolder.class);

    private final Map<FigureType, FigureCalculateService> figureServicesMap;

    public FigureHolder(List<FigureCalculateService> figureServices) {
        this.figureServicesMap = figureServices.stream()
                .collect(Collectors.toMap(FigureCalculateService::getFigureServiceType, Function.identity()));
    }

    public FigureCalculateService getFigureCalculateService(FigureType figureType) {
        FigureCalculateService service = figureServicesMap.get(figureType);
        checkService(service, figureType);
        return service;
    }

    private void checkService(FigureCalculateService service, FigureType figureType) {
        if (service == null) {
            String msg = String.format("Service with name: %s not exist", figureType);
            logger.error(msg);
            throw new RuntimeException(msg);
        }
    }
}
