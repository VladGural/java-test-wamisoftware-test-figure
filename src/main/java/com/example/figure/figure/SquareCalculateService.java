package com.example.figure.figure;

import com.example.figure.domain.FigureCalculateRequest;
import com.example.figure.domain.FigureCalculateResponse;
import com.example.figure.domain.FigureCalculateService;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class SquareCalculateService implements FigureCalculateService {

    @Override
    public FigureCalculateResponse calculate(FigureCalculateRequest request) {
        FigureCalculateRequest.SquareFigureCalculateRequest square =
                (FigureCalculateRequest.SquareFigureCalculateRequest) request;
        FigureCalculateResponse calculateResponse = new FigureCalculateResponse();
        calculateResponse.setArea(Math.pow(square.getLength(), 2));
        calculateResponse.setPerimeter(square.getLength() * 4);
        return calculateResponse;
    }
}
