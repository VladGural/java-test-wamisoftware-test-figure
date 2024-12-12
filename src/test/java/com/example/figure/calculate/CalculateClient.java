package com.example.figure.calculate;

import com.example.figure.component_test.BaseComponentTest;
import com.example.figure.domain.FigureCalculateRequest;
import com.example.figure.domain.FigureCalculateResponse;
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
        FigureCalculateRequest.SquareFigureCalculateRequest squareFigureCalculateRequest =
                new FigureCalculateRequest.SquareFigureCalculateRequest();
        squareFigureCalculateRequest.setFigureType(FigureType.SQUARE);
        squareFigureCalculateRequest.setLength(length);
        String post = rest.post(url, squareFigureCalculateRequest, HttpStatus.CREATED);
        FigureCalculateResponse calculateResponse = Util.fromJson(post, FigureCalculateResponse.class);
        assertThat(calculateResponse.getArea(), closeTo(Math.pow(length, 2), 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(length * 4, 0.001));
    }

    public static void calculateRectangleProperties(BaseComponentTest rest, double aLength,
                                                    double bLength) throws Exception {
        String url = "/v1/figures/properties";
        FigureCalculateRequest.RectangleFigureCalculateRequest rectangleFigureCalculateRequest =
                new FigureCalculateRequest.RectangleFigureCalculateRequest();
        rectangleFigureCalculateRequest.setFigureType(FigureType.RECTANGLE);
        rectangleFigureCalculateRequest.setALength(aLength);
        rectangleFigureCalculateRequest.setBLength(bLength);
        String post = rest.post(url, rectangleFigureCalculateRequest, HttpStatus.CREATED);
        FigureCalculateResponse calculateResponse = Util.fromJson(post, FigureCalculateResponse.class);
        assertThat(calculateResponse.getArea(), closeTo(aLength * bLength, 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(aLength * 2 + bLength * 2, 0.001));
    }

    public static void calculateTriangleProperties(BaseComponentTest rest, double aLength,
                                                   double bLength, double cLength) throws Exception {
        String url = "/v1/figures/properties";
        FigureCalculateRequest.TriangleFigureCalculateRequest triangleFigureCalculateRequest =
                new FigureCalculateRequest.TriangleFigureCalculateRequest();
        triangleFigureCalculateRequest.setFigureType(FigureType.TRIANGLE);
        triangleFigureCalculateRequest.setALength(aLength);
        triangleFigureCalculateRequest.setBLength(bLength);
        triangleFigureCalculateRequest.setCLength(cLength);
        String post = rest.post(url, triangleFigureCalculateRequest, HttpStatus.CREATED);
        FigureCalculateResponse calculateResponse = Util.fromJson(post, FigureCalculateResponse.class);
        double p = aLength + bLength + cLength;
        double halfP = p / 2;
        assertThat(calculateResponse.getArea(), closeTo(Math.sqrt(halfP * (halfP - aLength) * (halfP - bLength) *
                        (halfP - cLength)), 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(p, 0.001));
    }

    public static void calculateCircleProperties(BaseComponentTest rest, double radius) throws Exception {
        String url = "/v1/figures/properties";
        FigureCalculateRequest.CircleFigureCalculateRequest circleFigureCalculateRequest =
                new FigureCalculateRequest.CircleFigureCalculateRequest();
        circleFigureCalculateRequest.setFigureType(FigureType.CIRCLE);
        circleFigureCalculateRequest.setRadius(radius);
        String post = rest.post(url, circleFigureCalculateRequest, HttpStatus.CREATED);
        FigureCalculateResponse calculateResponse = Util.fromJson(post, FigureCalculateResponse.class);
        assertThat(calculateResponse.getArea(), closeTo(Math.PI * Math.pow(radius, 2), 0.001));
        assertThat(calculateResponse.getPerimeter(), closeTo(2 * Math.PI * radius, 0.001));
    }
}
