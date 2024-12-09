package com.example.figure.calculate;

import com.example.figure.component_test.BaseComponentTest;
import com.example.figure.domain.type.FigureType;
import com.example.figure.util.Util;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

/**
 * @author Vladyslav Gural
 * @version 2024-12-09
 */
public class CalculateClient {

    public static void calculateSquareProperties(BaseComponentTest rest, double length) throws Exception {
        String url = "/v1/figures/properties";
        SquareParam squareParam = new SquareParam().setLength(length);
        CalculateRequest req = new CalculateRequest()
                .setFigureType(FigureType.SQUARE)
                .setFigureRequestParam(Util.toJson(squareParam));
        String post = rest.post(url, req, HttpStatus.CREATED);
        CalculateResponse calculateResponse = Util.fromJson(post, CalculateResponse.class);
        assertThat(calculateResponse.getArea(), closeTo(Math.pow(length, 2), 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(length * 4, 0.001));
    }

    public static void calculateRectangleProperties(BaseComponentTest rest, double aLength,
                                                    double bLength) throws Exception {
        String url = "/v1/figures/properties";
        RectangleParam rectangleParam = new RectangleParam().setALength(aLength).setBLength(bLength);
        CalculateRequest req = new CalculateRequest()
                .setFigureType(FigureType.RECTANGLE)
                .setFigureRequestParam(Util.toJson(rectangleParam));
        String post = rest.post(url, req, HttpStatus.CREATED);
        CalculateResponse calculateResponse = Util.fromJson(post, CalculateResponse.class);
        assertThat(calculateResponse.getArea(), closeTo(aLength * bLength, 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(aLength * 2 + bLength * 2, 0.001));
    }

    public static void calculateTriangleProperties(BaseComponentTest rest, double aLength,
                                                   double bLength, double cLength) throws Exception {
        String url = "/v1/figures/properties";
        TriangleParam triangleParam = new TriangleParam().setALength(aLength).setBLength(bLength).setCLength(cLength);
        CalculateRequest req = new CalculateRequest()
                .setFigureType(FigureType.TRIANGLE)
                .setFigureRequestParam(Util.toJson(triangleParam));
        String post = rest.post(url, req, HttpStatus.CREATED);
        CalculateResponse calculateResponse = Util.fromJson(post, CalculateResponse.class);
        double p = aLength + bLength + cLength;
        double halfP = p / 2;
        assertThat(calculateResponse.getArea(), closeTo(Math.sqrt(halfP * (halfP - aLength) * (halfP - bLength) *
                        (halfP - cLength)), 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(p, 0.001));
    }

    public static void calculateCircleProperties(BaseComponentTest rest, double radius) throws Exception {
        String url = "/v1/figures/properties";
        CircleParam circleParam = new CircleParam().setRadius(radius);
        CalculateRequest req = new CalculateRequest()
                .setFigureType(FigureType.CIRCLE)
                .setFigureRequestParam(Util.toJson(circleParam));
        String post = rest.post(url, req, HttpStatus.CREATED);
        CalculateResponse calculateResponse = Util.fromJson(post, CalculateResponse.class);
        assertThat(calculateResponse.getArea(), closeTo(Math.PI * Math.pow(radius, 2), 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(2 * Math.PI * radius, 0.001));
    }
}
