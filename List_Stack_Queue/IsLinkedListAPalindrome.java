public class IsLinkedListAPalindrome {
    public static boolean isLinkedListAPalindrome(ListNode<Integer> l) {
        if (l == null) {
            return true;
        }
        ListNode<Integer> slow = l, fast = l;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode<Integer> firstHalf = l;
        ListNode<Integer> secondHalf = ReverseLinkedListIterative.reverseLinkedList(slow);
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            ListNode<Integer> head = null;
            // Input the node's value in reverse order.
            for (String element : args) {
                ListNode<Integer> curr = new ListNode<>(Integer.parseInt(element), head);
                head = curr;
            }
            System.out.println(((isLinkedListAPalindrome(head)) ? "Yes" : "No"));
        }
        assert (isLinkedListAPalindrome(null));
        assert (isLinkedListAPalindrome(new ListNode<>(1, null)));
        assert (isLinkedListAPalindrome(new ListNode<>(1, new ListNode<>(1, null))));
        assert (!isLinkedListAPalindrome(new ListNode<>(1, new ListNode<>(2, null))));
        assert (!isLinkedListAPalindrome(
                new ListNode<>(1, new ListNode<>(3, new ListNode<>(2, new ListNode<>(1, null))))));

        ListNode<Integer> head = null;
        // A link list is a palindrome.
        for (int i = 6; i >= 1; --i) {
            ListNode<Integer> curr = new ListNode<>(1, head);
            head = curr;
        }
        assert (isLinkedListAPalindrome(head));

        // Still a palindrome linked list.
        head = null;
        for (int i = 5; i >= 1; --i) {
            ListNode<Integer> curr = new ListNode<>(1, head);
            head = curr;
        }
        head.next.next.data = 3;
        assert (isLinkedListAPalindrome(head));
        // Not a palindrome linked list.
        head = null;
        for (int i = 5; i >= 1; --i) {
            ListNode<Integer> curr = new ListNode<>(i, head);
            head = curr;
        }
        assert (!isLinkedListAPalindrome(head));
    }
}
