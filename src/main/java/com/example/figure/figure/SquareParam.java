package com.example.figure.figure;

import javax.validation.constraints.NotNull;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class SquareParam {

    @NotNull
    private Double length;

    public Double getLength() {
        return length;
    }

    public SquareParam setLength(Double length) {
        this.length = length;
        return this;
    }

    @Override
    public String toString() {
        return "SquareParam{" +
                "length=" + length +
                '}';
    }
}
