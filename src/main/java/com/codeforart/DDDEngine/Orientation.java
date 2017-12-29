package com.codeforart.DDDEngine;

enum ORIENTATION {
    COUNTERCLOCKWISE,
    CLOCKWISE,
    COLINEAR
}


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
}
