import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class AvgTopThreeScore {
    public static String findStudentWithHighestThreeScores(Iterator<Object> nameScoreData) {
        Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();
        while (nameScoreData.hasNext()) {
            String name = (String)nameScoreData.next();
            Integer score = (Integer)nameScoreData.next();

            PriorityQueue<Integer> scores = studentScores.get(name);
            if (scores == null) {
                scores = new PriorityQueue<Integer>();
                studentScores.put(name, scores);
            }
            scores.add(score);
            if (scores.size() > 3) {
                scores.poll();
            }
        }

        String topStudent = "No student";
        Integer currentTopThreeSum = 0;
        for (Map.Entry<String, PriorityQueue<Integer>> scores : studentScores.entrySet()) {
            if (scores.getValue().size() == 3) {
                int currentSum = getTopThreeSum(scores.getValue());
                if (currentSum > currentTopThreeSum) {
                    currentTopThreeSum = currentSum;
                    topStudent = scores.getKey();
                }
            }
        }
        return topStudent;
    }

    private static Integer getTopThreeSum(PriorityQueue<Integer> scores) {
        Iterator<Integer> it = scores.iterator();
        Integer sum = 0;
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }
}
