import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EvenOddMerge {
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> l) {
        if (l == null) {
            return null;
        }
        ListNode<Integer> evenHead = new ListNode<Integer>(0, null);
        ListNode<Integer> oddHead = new ListNode<Integer>(0, null);
        List<ListNode<Integer>> tails = Arrays.asList(evenHead, oddHead);
        int turn = 0;
        for (ListNode<Integer> iter = l; iter != null; iter = iter.next) {
            tails.get(turn).next = iter;
            tails.set(turn, tails.get(turn).next);
            turn ^= 1;
        }
        tails.get(1).next = null;
        tails.get(0).next = oddHead.next;
        return evenHead.next;
    }

    public static ListNode<Integer> evenOddMergeOriginal(ListNode<Integer> L) {
        if (L == null) {
            return L;
        }

        ListNode<Integer> evenListHead = L, evenListIter = evenListHead;
        ListNode<Integer> predecessorEvenListIter = null;
        ListNode<Integer> oddListHead = L.next, oddListIter = oddListHead;

        while (evenListIter != null && oddListIter != null) {
            evenListIter.next = oddListIter.next;
            predecessorEvenListIter = evenListIter;
            evenListIter = evenListIter.next;
            if (evenListIter != null) {
                oddListIter.next = evenListIter.next;
                oddListIter = oddListIter.next;
            }
        }

        // Appends odd list to the tail of even list.
        if (evenListIter != null) {
            evenListIter.next = oddListHead;
        } else {
            predecessorEvenListIter.next = oddListHead;
        }
        return evenListHead;
    }

    private static void simpleTest() {
        ListNode<Integer> L = new ListNode<>(0, null);
        ListNode<Integer> result = evenOddMerge(L);
        assert (result.data == 0);
        assert (result.next == null);

        L.next = new ListNode<Integer>(1, null);
        result = evenOddMerge(L);
        assert (result.data == 0);
        assert (result.next.data == 1);
        assert (result.next.next == null);

        L.next.next = new ListNode<Integer>(2, null);
        result = evenOddMerge(L);
        assert (result.data == 0);
        assert (result.next.data == 2);
        assert (result.next.next.data == 1);
        assert (result.next.next.next == null);
    }

    private static ListNode<Integer> createList(int n) {
        ListNode<Integer> head = null;
        for (int i = n - 1; i >= 0; --i) {
            ListNode<Integer> curr = new ListNode<>(i, null);
            curr.next = head;
            head = curr;
        }
        return head;
    }

    private static void checkAnswer(ListNode<Integer> L, int n) {
        int x = 0, count = 0;
        while (L != null) {
            ++count;
            assert (x == L.data);
            x += 2;
            if (x >= n) {
                x = 1;
            }
            System.out.println(L.data);
            L = L.next;
        }
        assert (count == n);
    }

    public static void main(String[] args) {
        simpleTest();
        Random gen = new Random();
        int n = 0;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            n = gen.nextInt(1000) + 1;
        }
        ListNode<Integer> head = createList(n);
        checkAnswer(evenOddMerge(head), n);
        ListNode<Integer> anotherHead = createList(n);
        checkAnswer(evenOddMergeOriginal(anotherHead), n);
    }
}
