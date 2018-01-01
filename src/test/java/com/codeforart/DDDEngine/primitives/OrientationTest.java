package com.codeforart.DDDEngine.primitives;

import org.junit.Test;

import static com.codeforart.DDDEngine.primitives.Orientation.orientation;
import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void shouldDetermineIsOnSegment() {
        Point p = new Point(0, 0);
        Point q = new Point(1, 0);
        Point r = new Point(2, 0);
        Point s = new Point(-2, -10);

        assertThat(Orientation.onSegment(p, q, r)).isTrue();
        assertThat(Orientation.onSegment(p, r, q)).isFalse();
        assertThat(Orientation.onSegment(p, s, r)).isFalse();

        Point pn = new Point(Point.MIN_VALUE, 0);
        Point pp = new Point(Point.MAX_VALUE, 0);

        assertThat(Orientation.onSegment(pn, p, pp)).isTrue();
    }

    @Test
    public void shouldReturnProperOrientation() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(4, 3);

        assertThat(orientation(p0, p1, p2)).isEqualTo(Orientation.COLINEAR);
        assertThat(orientation(p0, p1, p3)).isEqualTo(Orientation.CLOCKWISE);
        assertThat(orientation(p0, p3, p1)).isEqualTo(Orientation.COUNTERCLOCKWISE);
    }

    @Test
    public void shouldReturnProperOrientationWithMaxNumbers() {
        Point p0 = new Point(Point.MAX_VALUE, 0);
        Point p1 = new Point(Point.MIN_VALUE, 0);
        Point p2 = new Point(0, Point.MAX_VALUE);
        Point p3 = new Point(0, Point.MIN_VALUE);

        assertThat(orientation(p0, p1, p2)).isEqualTo(Orientation.CLOCKWISE);
        assertThat(orientation(p0, p1, p3)).isEqualTo(Orientation.COUNTERCLOCKWISE);
        assertThat(orientation(p1, new Point(0, 0), p1)).isEqualTo(Orientation.COLINEAR);
    }

    @Test
    public void shouldReturnProperOrientationWithLongNumbers() {
        Point p0 = new Point(Long.MIN_VALUE, 0);
        Point p1 = new Point(Long.MAX_VALUE, 0);
        Point p2 = new Point(0, Long.MAX_VALUE);
        Point p3 = new Point(0, Long.MIN_VALUE);

        assertThat(orientation(p0, p1, p2)).isEqualTo(Orientation.COUNTERCLOCKWISE);
        assertThat(orientation(p0, p1, p3)).isEqualTo(Orientation.CLOCKWISE);
        assertThat(orientation(p1, new Point(0, 0), p1)).isEqualTo(Orientation.COLINEAR);
    }
}