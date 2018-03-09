import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {
    public static class Interval {
        public Integer start;
        public Integer end;

        public Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        int i = 0;
        while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
            result.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() && newInterval.end > intervals.get(i).start) {
            newInterval = new Interval(
                Math.min(newInterval.start, intervals.get(i).start),
                Math.max(newInterval.end, intervals.get(i).end)
            );
            i++;
        }
        result.add(newInterval);

        result.addAll(intervals.subList(i, intervals.size()));

        return result;
    }
}
