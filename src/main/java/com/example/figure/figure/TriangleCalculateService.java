package com.example.figure.figure;

import com.example.figure.domain.CalculateRequest;
import com.example.figure.domain.CalculateResponse;
import com.example.figure.util.Util;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class TriangleCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        TriangleParam triangle = Util.fromJson(request.getFigureRequestParam(), TriangleParam.class);
        double a = triangle.getALength();
        double b = triangle.getBLength();
        double c = triangle.getCLength();
        double perimeter = a + b + c;
        double halfPerimeter = perimeter / 2;
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b *
                (halfPerimeter - c))));
        calculateResponse.setPerimeter(perimeter);
        return calculateResponse;
    }
}
