
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        pre_node = None
        first_node = head
        n_step_node = head

        for i in range(n):
            n_step_node = n_step_node.next

        while n_step_node is not None:
            pre_node = first_node
            first_node = first_node.next
            n_step_node = n_step_node.next

        if pre_node is None:
            head = head.next
        else:
            pre_node.next = first_node.next

        return head