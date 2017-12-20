import java.util.Random;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ViewSunset {
    private static class BuildingWithHeight {
        public Integer id;
        public Integer height;

        public BuildingWithHeight(int index, int height) {
            this.id = index;
            this.height = height;
        }
    }

    public static Deque<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> sequence) {
        int idx = 0;
        Deque<BuildingWithHeight> buildingsWithSunset = new LinkedList<>();
        while (sequence.hasNext()) {
            Integer height = sequence.next();
            while (!buildingsWithSunset.isEmpty() && buildingsWithSunset.getLast().height <= height) {
                buildingsWithSunset.removeLast();
            }
            buildingsWithSunset.addLast(new BuildingWithHeight(idx++, height));
        }
        return buildingsWithSunset;
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int times = 0; times < 1000; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.parseInt(args[0]);
            } else {
                n = r.nextInt(10000) + 1;
            }
            List<Integer> A = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                Integer height = r.nextInt(2 * n) + 1;
                A.add(height);
            }
            Deque<BuildingWithHeight> res = examineBuildingsWithSunset(A.iterator());
            BuildingWithHeight prev = res.removeFirst();
            System.out.println(prev);
            while (!res.isEmpty()) {
                BuildingWithHeight current = res.removeFirst();
                System.out.println(current);
                assert (prev.id < current.id);
                assert (prev.height > current.height);
                prev = current;
            }
        }
    }
}
