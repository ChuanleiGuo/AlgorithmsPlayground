import java.util.Arrays;
import java.util.Comparator;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    // DP
    // public int eraseOverlapIntervals(Interval[] intervals) {
    //     if (intervals.length == 0) {
    //         return 0;
    //     }        
    //     Arrays.sort(intervals, new Comparator<Interval>() {
    //         @Override
    //         public int compare(Interval o1, Interval o2) {
    //             if (o1.start != o2.start) {
    //                 return o1.start - o2.start;
    //             } else {
    //                 return o1.end - o2.end;
    //             }
    //         }
    //     });
    //     int[] memo = new int[intervals.length];
    //     Arrays.fill(memo, 1);
    //     for (int i = 1; i < memo.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (intervals[i].start >= intervals[j].end) {
    //                 memo[i] = Math.max(memo[i], 1 + memo[j]);
    //             }
    //         }
    //     }

    //     int res = 0;
    //     for (int m : memo) {
    //         res = Math.max(res, m);
    //     }

    //     return intervals.length - res;
    // }

    // greedy
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }

        return intervals.length - res;
    }
}