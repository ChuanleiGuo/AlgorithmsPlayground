import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskPairing {

    public static class PairedTasks {
        public Integer task1;
        public Integer task2;

        public PairedTasks(Integer task1, Integer task2) {
            this.task1 = task1;
            this.task2 = task2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            PairedTasks that = (PairedTasks) o;

            return task1.equals(that.task1) && task2.equals(that.task2);
        }

        @Override
        public String toString() {
            return "[" + task1 + ", " + task2 + "]";
        }
    }

    public static List<PairedTasks> optimumTaskAssignment(List<Integer> taskDurations) {
        Collections.sort(taskDurations);
        List<PairedTasks> optAssignments = new ArrayList<>();
        for (int i = 0, j = taskDurations.size() - 1; i < j; i++, j--) {
            optAssignments.add(new PairedTasks(taskDurations.get(i), taskDurations.get(j)));
        }
        return optAssignments;
    }

}
