import edu.princeton.cs.algs4.*;

public class Permutation {
    public static void main(String[] args) {
        int cycles = Integer.parseInt(args[0]);
        int counter = 0;
        RandomizedQueue rand = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            rand.enqueue(StdIn.readString());
        }

        while (counter < cycles) {
            System.out.println(rand.dequeue());
            counter += 1;
        }
    }
}