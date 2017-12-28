package com.codeforart.DDDEngine;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeTest {

    @Test
    public void shouldThrowErrorWhenNotEnoughPoints() {
        Point pointA = new Point(100, 200);

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> {
            Shape shape = new Shape.Builder().build();
        });

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> {
            Shape shape = new Shape.Builder().add(pointA).build();
        });

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> {
            Shape shape = new Shape.Builder().add(pointA).add(pointA).build();
        });

    }

    @Test
    public void shouldCheckIfPointIsInsideShape() {
        Shape triangle = new Shape.Builder().add(new Point(10, 10))
                .add(new Point(-10, 10))
                .add(new Point(-10, -10))
                .add(new Point(10, 10))
                .build();

        assertThat(triangle.isWithin(new Point(0,0))).isTrue();
    }

}