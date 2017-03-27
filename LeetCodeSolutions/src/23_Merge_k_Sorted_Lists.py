import heapq


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


'''
并归法
'''

#
# class Solution(object):
#     def mergeTwoLists(self, l1, l2):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         head = ListNode(0)
#         rear = head
#         head1, head2 = l1, l2
#
#         while head1 is not None and head2 is not None:
#             if head1.val < head2.val:
#                 rear.next = head1
#                 head1 = head1.next
#             else:
#                 rear.next = head2
#                 head2 = head2.next
#             rear = rear.next
#             rear.next = None
#
#         if head1 is not None:
#             rear.next = head1
#
#         if head2 is not None:
#             rear.next = head2
#
#         return head.next
#
#     def mergeKLists(self, lists):
#         """
#         :type lists: List[ListNode]
#         :rtype: ListNode
#         """
#         if len(lists) == 0 or lists is None:
#             return None
#         if len(lists) == 1:
#             return lists[0]
#         mid = (len(lists) - 1) / 2
#         l1 = self.mergeKLists(lists[0: mid + 1])
#         l2 = self.mergeKLists(lists[mid + 1: len(lists)])
#
#         return self.mergeTwoLists(l1, l2)

'''
使用优先队列
'''


class Solution(object):

    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        min_heap, head = [(node.val, node) for node in lists if node], ListNode(0)
        heapq.heapify(min_heap)
        p = head
        while min_heap:
            _, node = heapq.heappop(min_heap)
            if node.next:
                heapq.heappush(min_heap, (node.next.val, node.next))
            p.next = node
            p = p.next
        return head.next