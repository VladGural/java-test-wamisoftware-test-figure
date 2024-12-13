package com.example.figure.figure;

import com.example.figure.domain.FigureCalculateService;
import com.example.figure.domain.type.FigureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@Component
public class FigureHolder {
    private static final Logger logger = LoggerFactory.getLogger(FigureHolder.class);

    private final List<FigureCalculateService> figureServices;

    public FigureHolder(List<FigureCalculateService> figureServices) {
        this.figureServices = figureServices;
    }

    public FigureCalculateService getFigureCalculateService(FigureType figureType) {
        FigureCalculateService service = getFigureService(figureType);
        checkService(service, figureType);
        return service;
    }

    private FigureCalculateService getFigureService(FigureType serviceType) {
        return figureServices.stream()
                .filter(s -> s.getFigureServiceType().equals(serviceType))
                .findFirst().orElse(null);
    }

    private void checkService(FigureCalculateService service, FigureType figureType) {
        if (service == null) {
            String msg = String.format("Service with name: %s not exist", figureType);
            logger.error(msg);
            throw new RuntimeException(msg);
        }
    }
}
