package com.codeforart.DDDEngine.primitives;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeTest {

    Shape shape;

    @Before
    public void buildShape() {
        shape = new Shape.Builder().defaultTestShape();
    }

    @Test
    public void shouldThrowErrorWhenNotEnoughPoints() {
        Point pointA = new Point(1000, 200);

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> new Shape.Builder().build());

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> new Shape.Builder().add(pointA).build());

        Assertions.assertThatExceptionOfType(Shape.Builder.NotEnoughPointsException.class).isThrownBy(() -> new Shape.Builder().add(pointA).add(pointA).build());

    }

    @Test
    public void shouldReturnPoints() {
        assertThat(shape.getPoints().size()).isEqualTo(5);
    }

    @Test
    public void shouldReturnSegments() {
        assertThat(shape.getEdges().size()).isEqualTo(shape.getPoints().size());
    }


    @Test
    public void shouldCheckIfPointIsInsideShape() {

        assertThat(shape.contains(new Point(0, 0))).isTrue();
        assertThat(shape.contains(new Point(10, 10))).isTrue();
        assertThat(shape.contains(new Point(49, 10))).isTrue();
        assertThat(shape.contains(new Point(49, 50))).isTrue();
        assertThat(shape.contains(new Point(1000, 1000))).isFalse();
    }

}