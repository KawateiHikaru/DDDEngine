package com.codeforart.DDDEngine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentTest {

    @Test
    public void shouldCalculateAngleBetweenPointAndEdge() {
        Segment e;
        e = new Segment(new Point(10,0), new Point(10, 10));
        assertThat(e.angleBetweenPoints(new Point(0,0))).isEqualTo(45.0f);
        assertThat(e.degreeBetweenPoints(new Point(0,0))).isEqualTo(Math.PI/4);

        e = new Segment(new Point(-10, -10), new Point(10, -10));
        assertThat(e.angleBetweenPoints(new Point(0,0))).isEqualTo(90.0f);
        assertThat(e.degreeBetweenPoints(new Point(0,0))).isEqualTo(Math.PI/2);

    }

}