package com.example.figure.figure;

import com.example.figure.domain.CalculateRequest;
import com.example.figure.domain.CalculateResponse;
import com.example.figure.util.Util;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class RectangleCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        RectangleParam rectangle = Util.fromJson(request.getFigureRequestParam(), RectangleParam.class);
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(rectangle.getALength() * rectangle.getBLength());
        calculateResponse.setPerimeter(rectangle.getALength() * 2 + rectangle.getBLength() * 2);
        return calculateResponse;
    }
}
