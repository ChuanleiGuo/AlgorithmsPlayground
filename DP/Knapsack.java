import java.util.Arrays;
import java.util.List;

public class Knapsack {

    public static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimumSubjectToCapacity(List<Item> items, int capacity) {
        int[][] table = new int[items.size()][capacity + 1];
        for (int[] row : table) {
            Arrays.fill(row, -1);
        }
        return optimumSubjectToItemAndCapacity(items, items.size() - 1, capacity, table);
    }

    private static int optimumSubjectToItemAndCapacity(List<Item> items, int k, int availableCapacity, int[][] table) {
        if (k < 0) {
            return 0;
        }
        if (table[k][availableCapacity] == -1) {
            int withoutCurrItem = optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity, table);
            int withCurrItem = availableCapacity < items.get(k).weight ? 0
                    : items.get(k).value + optimumSubjectToItemAndCapacity(items, k - 1,
                            availableCapacity - items.get(k).weight, table);
            table[k][availableCapacity] = Math.max(withoutCurrItem, withCurrItem);
        }
        return table[k][availableCapacity];
    }

}
