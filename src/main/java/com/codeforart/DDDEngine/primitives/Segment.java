package com.codeforart.DDDEngine.primitives;


import static com.google.common.base.Preconditions.checkNotNull;

public class Segment {

    private final Point p, q;

    @Override
    public int hashCode() {
        return (p.toString() + ":" + q.toString()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Segment)) {
            return false;
        }

        Segment obj1 = (Segment) obj;
        return obj1.getP().equals(this.p) && obj1.getQ().equals(this.q);
    }

    Segment(Point p, Point q) {
        checkNotNull(p);
        checkNotNull(q);

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
        Point p1 = getP();
        Point q1 = getQ();
        Point p2 = s.getP();
        Point q2 = s.getQ();

        Orientation o1 = Orientation.orientation(p1, q1, p2);
        Orientation o2 = Orientation.orientation(p1, q1, q2);
        Orientation o3 = Orientation.orientation(p2, q2, p1);
        Orientation o4 = Orientation.orientation(p2, q2, q1);

        if (!o1.equals(o2) && !o3.equals(o4)) return true;

        if (Orientation.COLINEAR.equals(o1) && Orientation.onSegment(this.getP(), s.getP(), this.getQ())) return true;
        if (Orientation.COLINEAR.equals(o2) && Orientation.onSegment(this.getP(), s.getQ(), this.getQ())) return true;
        if (Orientation.COLINEAR.equals(o3) && Orientation.onSegment(s.getP(), this.getP(), s.getQ())) return true;
        return Orientation.COLINEAR.equals(o4) && Orientation.onSegment(s.getP(), this.getQ(), s.getQ());

    }

    public float getDistance() {
        return (float) Math.hypot(p.x - q.x, p.y - q.y);
    }
}
