package com.example.figure.figure;

import com.example.figure.domain.FigureCalculateRequest;
import com.example.figure.domain.FigureCalculateResponse;
import com.example.figure.domain.FigureCalculateService;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class RectangleCalculateService implements FigureCalculateService {

    @Override
    public FigureCalculateResponse calculate(FigureCalculateRequest request) {
        FigureCalculateRequest.RectangleFigureCalculateRequest rectangle =
                (FigureCalculateRequest.RectangleFigureCalculateRequest) request;
        FigureCalculateResponse calculateResponse = new FigureCalculateResponse();
        calculateResponse.setArea(rectangle.getALength() * rectangle.getBLength());
        calculateResponse.setPerimeter(rectangle.getALength() * 2 + rectangle.getBLength() * 2);
        return calculateResponse;
    }
}
