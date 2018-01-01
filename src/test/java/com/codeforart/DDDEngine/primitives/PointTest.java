package com.codeforart.DDDEngine.primitives;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {


    @Test
    public void shouldHaveSameHashcodes() {
        Point p = new Point(0, 0);
        Point q = new Point(0, 0);

        assertThat(p.hashCode()).isEqualTo(q.hashCode());
    }

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
        Point p = new Point(1, 1);
        assertThat(p.negate()).isEqualTo(new Point(-1, -1));

        // 2s complement
        Point q = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
        assertThat(q.negate()).isEqualTo(new Point(Long.MIN_VALUE, Long.MIN_VALUE));
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

    @Test
    public void shouldConfinePointsWithinMaxAndMin() {
        Point p1 = new Point(Point.MAX_VALUE + 1, Point.MIN_VALUE - 1);
        assertThat(p1.x).isEqualTo(Point.MAX_VALUE);
        assertThat(p1.y).isEqualTo(Point.MIN_VALUE);
    }

}