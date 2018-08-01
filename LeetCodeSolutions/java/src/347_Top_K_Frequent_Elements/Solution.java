import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> (
                b.getValue() - a.getValue()
            )
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size() < k){
            Map.Entry<Integer, Integer> entry = pq.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}