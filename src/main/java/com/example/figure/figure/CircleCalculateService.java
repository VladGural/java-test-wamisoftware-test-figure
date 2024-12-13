package com.example.figure.figure;

import com.example.figure.domain.FigureCalculateRequest;
import com.example.figure.domain.FigureCalculateResponse;
import com.example.figure.domain.FigureCalculateService;
import com.example.figure.domain.type.FigureType;
import org.springframework.stereotype.Service;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@Service
public class CircleCalculateService implements FigureCalculateService {

    private final FigureType figureServiceType = FigureType.CIRCLE;

    @Override
    public FigureType getFigureServiceType() {
        return this.figureServiceType;
    }

    @Override
    public FigureCalculateResponse calculate(FigureCalculateRequest request) {
        FigureCalculateRequest.CircleFigureCalculateRequest circle =
                (FigureCalculateRequest.CircleFigureCalculateRequest) request;
        FigureCalculateResponse calculateResponse = new FigureCalculateResponse();
        calculateResponse.setArea(Math.PI * Math.pow(circle.getRadius(), 2));
        calculateResponse.setPerimeter(2 * Math.PI * circle.getRadius());
        return calculateResponse;
    }
}
