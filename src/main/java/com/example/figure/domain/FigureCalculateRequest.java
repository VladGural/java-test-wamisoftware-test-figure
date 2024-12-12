package com.example.figure.domain;

import com.example.figure.domain.type.FigureType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.validation.constraints.NotNull;

/**
 * @author Vladyslav Gural
 * @version 2024-12-12
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "figureType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FigureCalculateRequest.CircleFigureCalculateRequest.class, name = "CIRCLE"),
        @JsonSubTypes.Type(value = FigureCalculateRequest.RectangleFigureCalculateRequest.class, name = "RECTANGLE"),
        @JsonSubTypes.Type(value = FigureCalculateRequest.SquareFigureCalculateRequest.class, name = "SQUARE"),
        @JsonSubTypes.Type(value = FigureCalculateRequest.TriangleFigureCalculateRequest.class, name = "TRIANGLE"),
})
public class FigureCalculateRequest {
    @NotNull
    private FigureType figureType;

    public static class CircleFigureCalculateRequest extends FigureCalculateRequest {
        @NotNull
        private Double radius;

        public Double getRadius() {
            return radius;
        }

        public CircleFigureCalculateRequest setRadius(Double radius) {
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

    public static class RectangleFigureCalculateRequest extends FigureCalculateRequest {
        @NotNull
        private Double aLength;

        @NotNull
        private Double bLength;

        public Double getALength() {
            return aLength;
        }

        public RectangleFigureCalculateRequest setALength(Double aLength) {
            this.aLength = aLength;
            return this;
        }

        public Double getBLength() {
            return bLength;
        }

        public RectangleFigureCalculateRequest setBLength(Double bLength) {
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

    public static class SquareFigureCalculateRequest extends FigureCalculateRequest {
        @NotNull
        private Double length;

        public Double getLength() {
            return length;
        }

        public SquareFigureCalculateRequest setLength(Double length) {
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

    public static class TriangleFigureCalculateRequest extends FigureCalculateRequest {
        @NotNull
        private Double aLength;

        @NotNull
        private Double bLength;

        @NotNull
        private Double cLength;

        public Double getALength() {
            return aLength;
        }

        public TriangleFigureCalculateRequest setALength(Double aLength) {
            this.aLength = aLength;
            return this;
        }

        public Double getBLength() {
            return bLength;
        }

        public TriangleFigureCalculateRequest setBLength(Double bLength) {
            this.bLength = bLength;
            return this;
        }

        public Double getCLength() {
            return cLength;
        }

        public TriangleFigureCalculateRequest setCLength(Double cLength) {
            this.cLength = cLength;
            return this;
        }
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public FigureCalculateRequest setFigureType(FigureType figureType) {
        this.figureType = figureType;
        return this;
    }

    @Override
    public String toString() {
        return "FigureRequest{" +
                "figureType=" + figureType +
                '}';
    }
}
