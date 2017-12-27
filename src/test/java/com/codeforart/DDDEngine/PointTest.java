package com.codeforart.DDDEngine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void shouldCompareTwoPoints() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(1, 1);

        assertThat(p1).isEqualTo(p2);
        assertThat(p1).isNotEqualTo(p3);
    }

    @Test
    public void shouldAddTwoPoints() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, -1);

        assertThat(p1.add(p2)).isEqualTo(new Point(2, 0));
    }

    @Test
    public void shouldSubTwoPoints() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);

        assertThat(p1.sub(p2)).isEqualTo(new Point(0, 0));
    }

    @Test
    public void shouldNegate() {
        Point p1 = new Point(1, 1);
        assertThat(p1.negate()).isEqualTo(new Point(-1, -1));
    }

    @Test
    public void shouldGetAbs() {
        Point p1 = new Point(-1, -1);
        assertThat(p1.abs()).isEqualTo(new Point(1, 1));
    }

    @Test
    public void shouldGetDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(10, 0);

        assertThat(p1.distance(p2)).isEqualTo(10);
    }

}