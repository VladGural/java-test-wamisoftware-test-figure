package com.example.figure.figure;

import com.example.figure.domain.CalculateRequest;
import com.example.figure.domain.CalculateResponse;
import com.example.figure.util.Util;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class CircleCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        CircleParam circle = Util.fromJson(request.getFigureRequestParam(), CircleParam.class);
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(Math.PI * Math.pow(circle.getRadius(), 2));
        calculateResponse.setPerimeter(2 * Math.PI * circle.getRadius());
        return calculateResponse;
    }
}
