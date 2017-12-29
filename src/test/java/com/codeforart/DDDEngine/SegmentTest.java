package com.codeforart.DDDEngine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentTest {

    @Test
    public void shouldGetPandQ() {
        Segment e;
        e = new Segment(new Point(10, 0), new Point(10, 10));

        assertThat(e.getP()).isEqualTo(new Point(10, 0));
        assertThat(e.getQ()).isEqualTo(new Point(10, 10));
    }

    @Test
    public void shouldDetermineIfSegmentsIntersects() {

        Segment line1, line2;
        line1 = new Segment(new Point(1, 1), new Point(10, 1));
        line2 = new Segment(new Point(1, 2), new Point(10, 2));

        assertThat(line1.intersects(line2)).isEqualTo(false);

        line1 = new Segment(new Point(10, 0), new Point(0, 10));
        line2 = new Segment(new Point(0, 0), new Point(10, 10));
        assertThat(line1.intersects(line2)).isEqualTo(true);

        line1 = new Segment(new Point(-5, -5), new Point(0, 0));
        line2 = new Segment(new Point(1, 1), new Point(10, 10));
        assertThat(line1.intersects(line2)).isEqualTo(false);

    }

}