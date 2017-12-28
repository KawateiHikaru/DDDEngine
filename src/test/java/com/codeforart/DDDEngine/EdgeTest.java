package com.codeforart.DDDEngine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EdgeTest {

    @Test
    public void shouldCalculateAngleBetweenPointAndEdge() {
        Edge e = new Edge(new Point(10,0), new Point(10, 10));
        assertThat(e.angleBetweenPoints(new Point(0,0))).isEqualTo(45.0f);
        assertThat(e.degreeBetweenPoints(new Point(0,0))).isEqualTo(Math.PI/4);
    }

}