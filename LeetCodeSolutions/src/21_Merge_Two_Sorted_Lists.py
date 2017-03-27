# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        rear = head
        head1, head2 = l1, l2

        while head1 is not None and head2 is not None:
            if head1.val < head2.val:
                rear.next = head1
                head1 = head1.next
            else:
                rear.next = head2
                head2 = head2.next
            rear = rear.next
            rear.next = None

        if head1 is not None:
            rear.next = head1

        if head2 is not None:
            rear.next = head2

        return head.next

def add_new_node(l, node):
    rear = l
    while rear.next is not None:
        rear = rear.next
    rear.next = node
    rear = rear.next
    rear.next = None

def print_linked_list(l):
    p = l
    while p is not None:
        print p.val,
        if p.next is not None:
            print '->',
        p = p.next

    print '\n'

l1 = ListNode(1)

for i in range(0, 10, 2):
    add_new_node(l1, ListNode(i))

l1 = l1.next
print_linked_list(l1)

l2 = ListNode(2)

for i in range(1, 11, 2):
    add_new_node(l2, ListNode(i))

l2 = l2.next

print_linked_list(l2)

l3 = Solution().mergeTwoLists(l1, l2)
print_linked_list(l3)