package com.example.figure.figure;

import com.example.figure.domain.CalculateRequest;
import com.example.figure.domain.CalculateResponse;
import com.example.figure.util.Util;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class SquareCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        SquareParam square = Util.fromJson(request.getFigureRequestParam(), SquareParam.class);
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(Math.pow(square.getLength(), 2));
        calculateResponse.setPerimeter(square.getLength() * 4);
        return calculateResponse;
    }
}
