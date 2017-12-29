package com.codeforart.DDDEngine;


import static java.lang.Math.max;
import static java.lang.Math.min;

public class Orientation {

    private Orientation() {
        // protect from init
    }

    public static ORIENTATION orientation(Point p1, Point p2, Point p3) {
        float val = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) -
                (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());

        if (val == 0) return ORIENTATION.COLINEAR;

        return (val < 0) ? ORIENTATION.CLOCKWISE : ORIENTATION.COUNTERCLOCKWISE;
    }

    public static boolean onSegment(Point p, Point q, Point r) {
        return q.getX() <= max(p.getX(), r.getX()) && q.getX() >= min(p.getX(), r.getX()) &&
                q.getY() <= max(p.getY(), r.getY()) && q.getY() >= min(p.getY(), r.getY());

    }
}
