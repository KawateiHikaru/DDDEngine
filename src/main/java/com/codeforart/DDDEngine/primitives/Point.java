package com.codeforart.DDDEngine.primitives;


import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class Point {
    public static final long MAX_VALUE = 10000;
    public static final long MIN_VALUE = -10000;

    public final long x;
    public final long y;

    public Point(double x, double y) {
        this((long) x, (long) y);
    }

    private long limitInRange(long value) {
        return Math.min(Math.max(value, MIN_VALUE), MAX_VALUE);
    }

    public Point(long x, long y) {
        this.x = limitInRange(x);
        this.y = limitInRange(y);
    }

    /**
     * Added two points together and returns a new point
     *
     * @param p
     * @return
     */
    public Point add(@NotNull Point p) {
        checkNotNull(p);
        return new Point(this.x + p.x, this.y + p.y);
    }

    public Point negate() {
        return new Point(-this.x, -this.y);
    }

    public Point abs() {
        return new Point(
                this.x < 0 ? -this.x : this.x,
                this.y < 0 ? -this.y : this.y
        );
    }

    /**
     * Added two points together and returns a new point
     *
     * @param p
     * @return
     */
    public Point sub(@NotNull Point p) {
        checkNotNull(p);
        return this.add(p.negate());
    }

    /**
     * Should return the distance between this point and point p1
     *
     * @param p
     * @return
     */
    public double distance(@NotNull Point p) {
        checkNotNull(p);

        return Math.hypot(p.x - x, p.y - y);
    }

    @Override
    public int hashCode() {
        return (this.x + ":" + this.y).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        checkNotNull(obj);
        if (!(obj instanceof Point)) return false;

        Point p = (Point) obj;
        return p.x == this.x &&
                p.y == this.y;

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
