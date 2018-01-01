package com.codeforart.DDDEngine.primitives;


import static java.lang.Math.max;
import static java.lang.Math.min;

public enum Orientation {
    COUNTERCLOCKWISE,
    CLOCKWISE,
    COLINEAR;

    public static Orientation orientation(Point a, Point b, Point c) {
        
        double val = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);

        if (Double.isInfinite(val) || val != val) throw new RuntimeException();

        if (val == 0) return COLINEAR;

        return (val < 0) ? CLOCKWISE : COUNTERCLOCKWISE;
    }

    public static boolean onSegment(Point p, Point q, Point r) {
        return q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) &&
                q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y);

    }
}
