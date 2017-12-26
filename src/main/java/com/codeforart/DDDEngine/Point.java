package com.codeforart.DDDEngine;


import org.jetbrains.annotations.NotNull;

public class Point {

    private float x, y, z;

    public Point(@NotNull float x, @NotNull float y, @NotNull float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    /**
     * Added two points together and returns a new point
     *
     * @param p1
     * @return
     */
    public Point add(@NotNull Point p1) {
        return new Point(this.x + p1.x, this.y + p1.y, this.z + p1.z);
    }

    public Point negate() {
        return new Point(-this.x, -this.y, -this.z);
    }

    public Point abs() {
        return new Point(
                this.x < 0 ? -this.x: this.x,
                this.y < 0 ? -this.y: this.y,
                this.z < 0 ? -this.z: this.z
        );
    }

    /**
     * Added two points together and returns a new point
     *
     * @param p1
     * @return
     */
    public Point sub(@NotNull Point p1) {
        return this.add(p1.negate());
    }

    /**
     * Should return the distance between this point and point p1
     *
     * @param p1
     * @return
     */
    public Point distance(@NotNull Point p1) {

        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }

        Point p1 = (Point) obj;

        return p1.getX() == this.getX() &&
                p1.getY() == this.getY() &&
                p1.getZ() == this.getZ();

    }

}
