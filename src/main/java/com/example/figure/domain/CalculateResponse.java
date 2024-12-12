package com.example.figure.domain;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
public class CalculateResponse {
    private Double area;
    private Double perimeter;

    public Double getArea() {
        return area;
    }

    public CalculateResponse setArea(Double area) {
        this.area = area;
        return this;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public CalculateResponse setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
        return this;
    }

    @Override
    public String toString() {
        return "CalculateResponse{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
