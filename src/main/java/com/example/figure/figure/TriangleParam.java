package com.example.figure.figure;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@Valid
public class TriangleParam {

    @NotNull
    private Double aLength;

    @NotNull
    private Double bLength;

    @NotNull
    private Double cLength;

    public Double getALength() {
        return aLength;
    }

    public TriangleParam setALength(Double aLength) {
        this.aLength = aLength;
        return this;
    }

    public Double getBLength() {
        return bLength;
    }

    public TriangleParam setBLength(Double bLength) {
        this.bLength = bLength;
        return this;
    }

    public Double getCLength() {
        return cLength;
    }

    public TriangleParam setCLength(Double cLength) {
        this.cLength = cLength;
        return this;
    }
}
