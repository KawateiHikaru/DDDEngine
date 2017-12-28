package com.codeforart.DDDEngine;

public class Edge {
    public final Point point1, point2;

    Edge(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }

    public double angleBetweenPoints(Point point) {
        double angle = Math.toDegrees(Math.atan2(point2.getY() - point.getY(), point2.getX() - point.getX())) - Math.toDegrees(Math.atan2(point1.getY() - point.getY(), point1.getX() - point.getX()));
        return angle < 0 ? angle + 360 : angle;
    }

    public double degreeBetweenPoints(Point point) {
        return Math.toRadians(angleBetweenPoints(point));
    }
}
