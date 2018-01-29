import java.util.List;

public class FindMinMax {
    private static class MinMax {
        public Integer min;
        public Integer max;

        public MinMax(Integer min, Integer max) {
            this.min = min;
            this.max = max;
        }

        private static MinMax minMax(Integer a, Integer b) {
            return Integer.compare(b, a) < 0 ? new MinMax(b, a) : new MinMax(a, b);
        }
    }

    public static MinMax findMinMax(List<Integer> list) {
        if (list.size() <= 1) {
            return new MinMax(list.get(0), list.get(0));
        }
        MinMax globalMinMax = MinMax.minMax(list.get(0), list.get(1));

        for (int i = 2; i + 1 < list.size(); i += 2) {
            MinMax localMinMax = MinMax.minMax(list.get(i), list.get(i + 1));
            globalMinMax = new MinMax(Math.min(globalMinMax.min, localMinMax.min),
                                      Math.max(globalMinMax.max, localMinMax.max));
        }

        if ((list.size() % 2) != 0) {
            globalMinMax = new MinMax(Math.min(globalMinMax.min, list.get(list.size() - 1)),
                                      Math.max(globalMinMax.max, list.get(list.size() - 1)));
        }
        return globalMinMax;
    }
}
