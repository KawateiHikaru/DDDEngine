package com.codeforart.DDDEngine;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ShapeTest {

    @Test
    public void shouldThrowErrorWhenNotEnoughPoints() {
        Point pointA = new Point(100, 200);

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> {
            Shape shape = new Shape.Builder().build();
            System.out.println(shape);
        });

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> {
            Shape shape = new Shape.Builder().add(pointA).build();
            System.out.println(shape);
        });

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> {
            Shape shape = new Shape.Builder().add(pointA).add(pointA).build();
            System.out.println(shape);
        });

    }

}