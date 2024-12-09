/**
 * @author Vladyslav Gural
 * @version 2024-12-09
 */
package com.example.figure.calculate;

import com.example.figure.domain.type.FigureType;
import com.example.figure.util.Util;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

interface FigureCalculateService {
    CalculateResponse calculate(CalculateRequest request);
}

class CalculateRequest {
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

class CalculateResponse {
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

class SquareParam {

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

class SquareCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        SquareParam square = Util.fromJson(request.getFigureRequestParam(), SquareParam.class);
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(Math.pow(square.getLength(), 2));
        calculateResponse.setPerimeter(square.getLength() * 4);
        return calculateResponse;
    }
}

class RectangleParam {

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

class RectangleCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        RectangleParam rectangle = Util.fromJson(request.getFigureRequestParam(), RectangleParam.class);
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(rectangle.getALength() * rectangle.getBLength());
        calculateResponse.setPerimeter(rectangle.getALength() * 2 + rectangle.getBLength() * 2);
        return calculateResponse;
    }
}

@Valid
class TriangleParam {

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

class TriangleCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        TriangleParam triangle = Util.fromJson(request.getFigureRequestParam(), TriangleParam.class);
        double a = triangle.getALength();
        double b = triangle.getBLength();
        double c = triangle.getCLength();
        double perimeter = a + b + c;
        double halfPerimeter = perimeter / 2;
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b *
                (halfPerimeter - c))));
        calculateResponse.setPerimeter(perimeter);
        return calculateResponse;
    }
}

@Valid
class CircleParam {

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

class CircleCalculateService implements FigureCalculateService {

    @Override
    public CalculateResponse calculate(CalculateRequest request) {
        CircleParam circle = Util.fromJson(request.getFigureRequestParam(), CircleParam.class);
        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setArea(Math.PI * Math.pow(circle.getRadius(), 2));
        calculateResponse.setPerimeter(2 * Math.PI * circle.getRadius());
        return calculateResponse;
    }
}