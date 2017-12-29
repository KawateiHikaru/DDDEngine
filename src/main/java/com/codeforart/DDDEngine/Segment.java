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

    public boolean intersects(Segment s) {
        ORIENTATION o1 = Orientation.orientation(getP(), getQ(), s.getP());
        ORIENTATION o2 = Orientation.orientation(getP(), s.getQ(), getQ());
        ORIENTATION o3 = Orientation.orientation(s.getP(), s.getP(), s.getQ());
        ORIENTATION o4 = Orientation.orientation(s.getP(), s.getQ(), s.getQ());

        if (!o1.equals(o2) && !o3.equals(o4)) return true;

        if (ORIENTATION.COLINEAR.equals(o1) && Orientation.onSegment(this.getP(), s.getP(), this.getQ())) return true;
        if (ORIENTATION.COLINEAR.equals(o2) && Orientation.onSegment(this.getP(), s.getQ(), this.getQ())) return true;
        if (ORIENTATION.COLINEAR.equals(o3) && Orientation.onSegment(s.getP(), this.getP(), s.getQ())) return true;
        if (ORIENTATION.COLINEAR.equals(o4) && Orientation.onSegment(s.getP(), this.getQ(), s.getQ())) return true;

        return false;
    }

}
