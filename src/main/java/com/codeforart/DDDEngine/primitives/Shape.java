package com.codeforart.DDDEngine.primitives;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Shape {

    final List<Point> points = new ArrayList<>();

    private Shape(List<Point> points) {
        this.points.addAll(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Segment> getEdges() {
        return IntStream.range(0, points.size())
                .mapToObj(i -> new Segment(points.get(i), points.get((i + 1) % points.size())))
                .collect(ImmutableList.toImmutableList());
    }

    /**
     * Return true if the point p is within the shape
     *
     * @param p
     */
    public boolean contains(Point p) {
        Point q = new Point(Long.MAX_VALUE, p.y);

        long count = getEdges()
                .stream()
                .filter(e -> e.intersects(new Segment(p, q)))
                .count();

        return count % 2 == 1;
    }

    public static class Builder {
        public Shape defaultTestShape() {
            return add(new Point(0, 0))
                    .add(new Point(100, 0))
                    .add(new Point(50, 50))
                    .add(new Point(100, 100))
                    .add(new Point(0, 100))
                    .build();
        }

        static class NotEnoughPointsException extends RuntimeException {
        }

        List<Point> points = new LinkedList<>();

        public Builder add(Point p) {
            points.add(p);
            return this;
        }

        public Shape build() {
            if (this.points.size() < 3) {
                throw new NotEnoughPointsException();
            }

            Shape shape = new Shape(this.points);
            this.points = new LinkedList<>();

            return shape;
        }
    }


}
