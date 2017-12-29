package com.codeforart.DDDEngine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shape {

    final List<Point> points = new ArrayList<>();

    private Shape(List<Point> points) {
        this.points.addAll(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    private List<Segment> getEdges() {
        return IntStream.range(0, points.size())
                .mapToObj(i -> new Segment(points.get(i), points.get((i + 1) % points.size())))
                .collect(Collectors.toList());
    }

    /**
     * Return true if the point p is within the shape
     *
     * @param p
     */
    public boolean contains(Point p) {

//        double sum = getEdges().stream()
//                .mapToDouble(e -> e.angleBetweenPoints(p))
//                .sum();
//
//        System.out.println(sum);

//        return sum == 360;
        return false;
    }

    public static class Builder {
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
