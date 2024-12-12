package com.example.figure.figure;

import com.example.figure.domain.type.FigureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@Component
public class FigureHolder {
    private static final Logger logger = LoggerFactory.getLogger(FigureHolder.class);

    private final Map<FigureType, FigureCalculateService> serviceMap = new HashMap<>();

    public FigureHolder() {
        serviceMap.put(FigureType.SQUARE, new SquareCalculateService());
        serviceMap.put(FigureType.RECTANGLE, new RectangleCalculateService());
        serviceMap.put(FigureType.TRIANGLE, new TriangleCalculateService());
        serviceMap.put(FigureType.CIRCLE, new CircleCalculateService());
    }

    public FigureCalculateService getFigureCalculateService(FigureType figureType) {
        FigureCalculateService service = serviceMap.get(figureType);
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
