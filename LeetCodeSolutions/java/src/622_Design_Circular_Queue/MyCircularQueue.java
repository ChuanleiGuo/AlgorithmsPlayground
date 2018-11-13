public class MyCircularQueue {

    final int[] array;
    int head, tail = -1, len = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (!isFull()) {
            tail = (tail + 1) % array.length;
            array[tail] = value;
            len++;
            return true;
        } else {
            return false;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (!isEmpty()) {
            head = (head + 1) % array.length;
            len--;
            return true;
        } else {
            return false;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : array[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : array[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return len == array.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */