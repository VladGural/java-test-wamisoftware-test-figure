package com.example.figure.domain;

import com.example.figure.domain.type.FigureType;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public interface FigureCalculateService {
    FigureType getFigureServiceType();

    FigureCalculateResponse calculate(FigureCalculateRequest request);
}
