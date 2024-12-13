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
public class RectangleCalculateService implements FigureCalculateService {

    private final FigureType figureServiceType = FigureType.RECTANGLE;

    @Override
    public FigureType getFigureServiceType() {
        return this.figureServiceType;
    }

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
