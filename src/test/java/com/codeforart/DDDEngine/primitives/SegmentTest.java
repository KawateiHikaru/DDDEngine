package com.codeforart.DDDEngine.primitives;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentTest {

    @Test
    public void shouldCalculateSlope() {

    }

    @Test
    public void shouldReturnDistance() {
        Segment e;
        e = new Segment(new Point(0, 0), new Point(10, 0));
        assertThat(e.getDistance()).isEqualTo(10);

        e = new Segment(new Point(0, 0), new Point(Long.MAX_VALUE, Long.MAX_VALUE));
        assertThat(e.getDistance()).isEqualTo(14142.136f);

        e = new Segment(new Point(Long.MIN_VALUE, Long.MIN_VALUE), new Point(Long.MAX_VALUE, Long.MAX_VALUE));
        assertThat(e.getDistance()).isEqualTo(28284.271f);

        e = new Segment(new Point(0, 0), new Point(Long.MAX_VALUE, 0));
        assertThat(e.getDistance()).isEqualTo(Point.MAX_VALUE);

        e = new Segment(new Point(Long.MIN_VALUE, 0), new Point(Long.MAX_VALUE, 0));
        assertThat(e.getDistance()).isEqualTo(2 * Point.MAX_VALUE);
    }

    @Test
    public void shouldGetPandQ() {
        Segment e;
        e = new Segment(new Point(10, 0), new Point(10, 10));

        assertThat(e.getP()).isEqualTo(new Point(10, 0));
        assertThat(e.getQ()).isEqualTo(new Point(10, 10));
    }

    @Test
    public void shouldGetSameHashcode() {
        Segment e1 = new Segment(new Point(10, 0), new Point(10, 10));
        Segment e2 = new Segment(new Point(10, 0), new Point(10, 10));

        assertThat(e1).isEqualTo(e2);
        assertThat(e1.hashCode()).isEqualTo(e2.hashCode());
    }

    @Test
    public void shouldDetermineIfSegmentsIntersects() {
        Segment line1, line2;
        line1 = new Segment(new Point(0, -10), new Point(0, 10));
        line2 = new Segment(new Point(-10, 0), new Point(10, 0));
        assertThat(line1.intersects(line2)).isTrue();

        line1 = new Segment(new Point(10, 0), new Point(0, 10));
        line2 = new Segment(new Point(0, 0), new Point(10, 10));
        assertThat(line1.intersects(line2)).isTrue();

        line1 = new Segment(new Point(-5, -5), new Point(0, 0));
        line2 = new Segment(new Point(1, 1), new Point(10, 10));
        assertThat(line1.intersects(line2)).isFalse();

        line1 = new Segment(new Point(5, -5), new Point(5, 5));
        line2 = new Segment(new Point(0, 0), new Point(10, 0));
        assertThat(line1.intersects(line2)).isTrue();
    }

    @Test
    public void shouldDetermineIfInfiniteSegmentsIntersects() {
        Segment line1 = new Segment(new Point(0, Long.MIN_VALUE), new Point(0, Long.MAX_VALUE));
        Segment line2 = new Segment(new Point(Long.MIN_VALUE, 0), new Point(Long.MAX_VALUE, 0));
        assertThat(line1.intersects(line2)).isTrue();

    }

    @Test
    public void shouldDetermineIfMaxValueSegmentsIntersects() {
        Segment line1 = new Segment(new Point(0, Long.MIN_VALUE), new Point(0, Long.MAX_VALUE));
        Segment line2 = new Segment(new Point(Long.MIN_VALUE, 0), new Point(Long.MAX_VALUE, 0));

        assertThat(line1.intersects(line2)).isTrue();
    }
}