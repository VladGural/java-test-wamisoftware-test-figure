package com.example.figure.figure;

import com.example.figure.domain.CalculateRequest;
import com.example.figure.domain.CalculateResponse;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public interface FigureCalculateService {
    CalculateResponse calculate(CalculateRequest request);
}
