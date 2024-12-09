package com.example.figure.calculate;

import com.example.figure.domain.type.FigureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vladyslav Gural
 * @version 2024-12-09
 */
@Service
class CalculateService {
    private static final Logger logger = LoggerFactory.getLogger(CalculateResource.class);

    private final Map<FigureType, FigureCalculateService> serviceMap = new HashMap<>();

    public CalculateService() {
        serviceMap.put(FigureType.SQUARE, new SquareCalculateService());
        serviceMap.put(FigureType.RECTANGLE, new RectangleCalculateService());
        serviceMap.put(FigureType.TRIANGLE, new TriangleCalculateService());
        serviceMap.put(FigureType.CIRCLE, new CircleCalculateService());
    }

    CalculateResponse calculateFigureProperties(CalculateRequest request) {
        FigureCalculateService service = serviceMap.get(request.getFigureType());
        checkService(service, request.getFigureType());
        return service.calculate(request);
    }

    private void checkService(FigureCalculateService service, FigureType figureType) {
        if (service == null) {
            String msg = String.format("Service with name: %s not exist", figureType);
            logger.error(msg);
            throw new RuntimeException(msg);
        }
    }
}
