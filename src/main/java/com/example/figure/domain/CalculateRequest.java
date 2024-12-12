package com.example.figure.domain;

import com.example.figure.domain.type.FigureType;

import javax.validation.constraints.NotNull;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class CalculateRequest {
    @NotNull
    private FigureType figureType;

    @NotNull
    private String figureRequestParam;

    public FigureType getFigureType() {
        return figureType;
    }

    public CalculateRequest setFigureType(FigureType figureType) {
        this.figureType = figureType;
        return this;
    }

    public String getFigureRequestParam() {
        return figureRequestParam;
    }

    public CalculateRequest setFigureRequestParam(String figureRequestParam) {
        this.figureRequestParam = figureRequestParam;
        return this;
    }

    @Override
    public String toString() {
        return "CalculateRequest{" +
                "figureType=" + figureType +
                ", figureRequestParam='" + figureRequestParam + '\'' +
                '}';
    }
}
