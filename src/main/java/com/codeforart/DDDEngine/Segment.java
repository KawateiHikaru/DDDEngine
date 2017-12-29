package com.codeforart.DDDEngine;


public class Segment {

    public final Point p, q;

    Segment(Point p, Point q) {
        this.p = p;
        this.q = q;
    }

    public Point getP() {
        return p;
    }

    public Point getQ() {
        return q;
    }


}
