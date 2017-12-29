package com.codeforart.DDDEngine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void shouldDetermineIsOnSegment() {
        Point p = new Point(0, 0);
        Point q = new Point(10, 0);
        Point r = new Point(20, 0);

        assertThat(Orientation.onSegment(p, q, r)).isTrue();
        assertThat(Orientation.onSegment(p, r, q)).isFalse();
        assertThat(Orientation.onSegment(p, new Point(10,1), r)).isFalse();
    }

    @Test
    public void shouldReturnProperOrientation() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(1, 2);

        assertThat(ORIENTATION.CLOCKWISE).isEqualTo(Orientation.orientation(p1, p2, p3));
        assertThat(ORIENTATION.COUNTERCLOCKWISE).isEqualTo(Orientation.orientation(p1, p3, p2));
        assertThat(ORIENTATION.COLINEAR).isEqualTo(Orientation.orientation(p1, p1, p1));
    }
}