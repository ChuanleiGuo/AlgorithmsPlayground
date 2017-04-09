/******************************************************************************
 *  Compilation:  javac BruteCollinearPoints.java
 *  Execution:    java BruteCollinearPoints
 *  Dependencies: LineSegment.java Point.java 
 *  
 *  Examines 4 points at a time and checks whether they all lie on the same line segment,
 *  returning all such line segments
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BruteCollinearPoints {

    private final LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {
        checkNull(points);
        Point[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints);
        checkDuplicate(sortedPoints);

        final int N = points.length;
        List<LineSegment> list = new LinkedList<LineSegment>();

        for (int a = 0; a < N - 3; a ++) {
            Point pointA = sortedPoints[a];

            for (int b = a + 1; b < N - 2; b++) {
                Point pointB = sortedPoints[b];
                double slopeAB = pointB.slopeTo(pointA);

                for (int c = b + 1; c < N - 1; c++) {
                    Point pointC = sortedPoints[c];
                    double slopeAC = pointC.slopeTo(pointA);

                    if (slopeAC == slopeAB) {
                        for (int d = c + 1; d < N; d++) {
                            Point pointD = sortedPoints[d];
                            double slopeAD = pointD.slopeTo(pointA);

                            if (slopeAD == slopeAB) {
                                list.add(new LineSegment(pointA, pointD));
                            }
                        }
                    }
                }
            }
        }
        lineSegments = list.toArray(new LineSegment[0]);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return lineSegments.clone();
    }

    private void checkNull(Point[] points) {
        if (points == null) {
            throw new NullPointerException("The array \"Points\" is null.");
        }
        for (Point p: points) {
            if (p == null) {
                throw new NullPointerException("The array \"Points\" contains null element.");
            }
        }
    }

    private void checkDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Duplicate(s) found.");
            }
        }
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}