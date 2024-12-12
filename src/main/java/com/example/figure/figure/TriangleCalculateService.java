package com.example.figure.figure;

import com.example.figure.domain.FigureCalculateRequest;
import com.example.figure.domain.FigureCalculateResponse;
import com.example.figure.domain.FigureCalculateService;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class TriangleCalculateService implements FigureCalculateService {

    @Override
    public FigureCalculateResponse calculate(FigureCalculateRequest request) {
        FigureCalculateRequest.TriangleFigureCalculateRequest triangle =
                (FigureCalculateRequest.TriangleFigureCalculateRequest) request;
        double a = triangle.getALength();
        double b = triangle.getBLength();
        double c = triangle.getCLength();
        double perimeter = a + b + c;
        double halfPerimeter = perimeter / 2;
        FigureCalculateResponse calculateResponse = new FigureCalculateResponse();
        calculateResponse.setArea(Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b *
                (halfPerimeter - c))));
        calculateResponse.setPerimeter(perimeter);
        return calculateResponse;
    }
}
