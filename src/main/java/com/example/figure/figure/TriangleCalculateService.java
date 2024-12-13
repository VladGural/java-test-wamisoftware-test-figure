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
public class TriangleCalculateService implements FigureCalculateService {

    private final FigureType figureServiceType = FigureType.TRIANGLE;

    @Override
    public FigureType getFigureServiceType() {
        return this.figureServiceType;
    }

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
