import java.util.Iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;
    private final Random rand = new Random();

    @SuppressWarnings("unchecked")
    public RandomizedQueue() {
        items = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("item cannot be null");
        }

        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size] = item;
        size += 1;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("dequeue from empty queue");
        }

        int randomIndex = rand.nextInt(size);
        Item item = items[randomIndex];

        items[randomIndex] = items[size - 1];
        items[size - 1] = null;
        size -= 1; 

        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("sample from empty queue");
        }
        return items[rand.nextInt(size)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Item[] tmp = (Item[]) new Object[newCapacity];
        System.arraycopy(items, 0, tmp, 0, size);
        items = tmp;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private final Item[] iterItems;
        private final int iterSize;
        private int current;

        public RandomizedQueueIterator() {
            iterItems = items.clone();
            shuffle(iterItems);
            iterSize = size;
            current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < iterSize;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("next item does not exist");
            }
            return iterItems[current++];
        }

        private void shuffle(Item[] input) {
            for (int i = 0; i < size; i ++) {
                int idx = i + rand.nextInt(size - i);
                Item temp = input[i];
                input[i] = input[idx];
                input[idx] = temp;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}