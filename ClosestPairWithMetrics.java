import java.util.Arrays;
import java.util.Comparator;

public class ClosestPairWithMetrics {
    public static class Point {
        double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
    }

    public static double closestPair(Point[] points, Metrics metrics) {
        Point[] px = points.clone();
        Arrays.sort(px, Comparator.comparingDouble(p -> p.x));
        Point[] py = points.clone();
        Arrays.sort(py, Comparator.comparingDouble(p -> p.y));
        return closestPairRec(px, py, metrics, 1);
    }

    private static double closestPairRec(Point[] px, Point[] py, Metrics metrics, int depth) {
        metrics.updateDepth(depth);
        int n = px.length;
        if (n <= 3) return bruteForce(px, metrics);

        int mid = n / 2;
        Point midPoint = px[mid];

        Point[] qx = Arrays.copyOfRange(px, 0, mid);
        Point[] rx = Arrays.copyOfRange(px, mid, n);

        double d1 = closestPairRec(qx, py, metrics, depth + 1);
        double d2 = closestPairRec(rx, py, metrics, depth + 1);

        double d = Math.min(d1, d2);

        Point[] strip = Arrays.stream(py).filter(p -> Math.abs(p.x - midPoint.x) < d).toArray(Point[]::new);
        return Math.min(d, stripClosest(strip, d, metrics));
    }

    private static double bruteForce(Point[] points, Metrics metrics) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                metrics.incComparisons();
                double dist = dist(points[i], points[j]);
                if (dist < min) min = dist;
            }
        }
        return min;
    }

    private static double stripClosest(Point[] strip, double d, Metrics metrics) {
        double min = d;
        for (int i = 0; i < strip.length; i++) {
            for (int j = i + 1; j < strip.length && (strip[j].y - strip[i].y) < min; j++) {
                metrics.incComparisons();
                double dist = dist(strip[i], strip[j]);
                if (dist < min) min = dist;
            }
        }
        return min;
    }

    private static double dist(Point p1, Point p2) {
        return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }
}
