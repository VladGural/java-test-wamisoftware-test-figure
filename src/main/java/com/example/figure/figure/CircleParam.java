package com.example.figure.figure;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@Valid
public class CircleParam {

    @NotNull
    private Double radius;

    public Double getRadius() {
        return radius;
    }

    public CircleParam setRadius(Double radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public String toString() {
        return "CircleParam{" +
                "radius=" + radius +
                '}';
    }
}