package com.codeforart.DDDEngine;


import org.jetbrains.annotations.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class Point {

    private float x, y;

    public Point(@NotNull float x, @NotNull float y) {
        checkNotNull(x);
        checkNotNull(y);

        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
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
    public float distance(@NotNull Point p) {
        checkNotNull(p);

        return (float) Math.sqrt(
                Math.pow(p.x - this.x, 2) +
                        Math.pow(p.y - this.y, 2)
        );
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
        return p.getX() == this.getX() &&
                p.getY() == this.getY();

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
