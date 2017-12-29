package com.codeforart.DDDEngine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentTest {

    @Test
    public void shouldCalculateAngleBetweenPointAndEdge() {
        Segment e;
        e = new Segment(new Point(10,0), new Point(10, 10));

        e = new Segment(new Point(-10, -10), new Point(10, -10));
    }

    @Test
    public void shouldGetPandQ() {
        Segment e;
        e = new Segment(new Point(10,0), new Point(10, 10));

        assertThat(e.getP()).isEqualTo(new Point(10,0));
        assertThat(e.getQ()).isEqualTo(new Point(10,10));
    }

}