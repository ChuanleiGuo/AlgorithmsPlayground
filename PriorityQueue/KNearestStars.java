import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestStars {
    public static class Star implements Comparable<Star> {
        private double x, y, z;

        public Start(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star rhs) {
            return Double.compare(this.distance(), rhs.distance());
        }
    }

    public static List<Star> findClosestKStars(int k, Iterator<Star> stars) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        while (stars.hasNext()) {
            Star star = stars.next();
            maxHeap.add(star);
            if (maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }
        List<Star> orderedStars = new ArrayList<Star>(maxHeap);
        Collections.sort(orderedStars);
        return orderedStars;
    }
}
