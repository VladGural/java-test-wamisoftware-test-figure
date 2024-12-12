package com.example.figure.figure;

import javax.validation.constraints.NotNull;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class RectangleParam {

    @NotNull
    private Double aLength;

    @NotNull
    private Double bLength;

    public Double getALength() {
        return aLength;
    }

    public RectangleParam setALength(Double aLength) {
        this.aLength = aLength;
        return this;
    }

    public Double getBLength() {
        return bLength;
    }

    public RectangleParam setBLength(Double bLength) {
        this.bLength = bLength;
        return this;
    }

    @Override
    public String toString() {
        return "RectangleParam{" +
                "aLength=" + aLength +
                ", bLength=" + bLength +
                '}';
    }
}
