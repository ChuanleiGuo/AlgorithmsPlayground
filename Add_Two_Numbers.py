class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        p1 = l1
        p2 = l2
        result = ListNode(None)
        p3 = result
        s = 0
        carry = 0
        while (not p1 == None) and (not p2 == None):
            s = p1.val + p2.val + carry
            value = s % 10
            carry = s / 10
            node = ListNode(value)
            p3.next = node
            p3 = p3.next
            p1 = p1.next
            p2 = p2.next

        if p1 == None and p2 == None:
            node = ListNode(carry)
            if node.val == 1:
                p3.next = node
                p3 = p3.next
                carry = 0

        while not p1 == None:
            s = p1.val + carry
            value = s % 10
            carry = s / 10
            node = ListNode(value)
            p3.next = node
            p3 = p3.next
            p1 = p1.next

        while not p2 == None:
            s = p2.val + carry
            value = s % 10
            carry = s / 10
            node = ListNode(value)
            p3.next = node
            p3 = p3.next
            p2 = p2.next

        if carry == 1 :
            node = ListNode(carry)
            p3.next = node

        return result.next


def makeLinkedList(nums):
    l = ListNode(None)
    p = l
    for i in range(len(nums)):
        node = ListNode(nums[i])
        p.next = node
        p = p.next
    return l.next

def print_linkedList(l):
    p = l
    while not p == None:
        print p.val,
        if not p.next == None:
            print " -> ",
        p = p.next

def test_cases(nums1, nums2):
    l1 = makeLinkedList(nums1)
    l2 = makeLinkedList(nums2)

    print ""
    print "l1 :",
    print_linkedList(l1)
    print ""

    print "l2 :",
    print_linkedList(l2)
    print ""

    print "l3 :",
    l3 = Solution().addTwoNumbers(l1, l2)
    print_linkedList(l3)
    print ""

"""nums1 = [2, 3, 4]
nums2 = [5, 6, 7]

test_cases(nums1, nums2)

nums1 = [2, 4, 3]
nums2 = [5, 6, 4]
test_cases(nums1, nums2)
nums1 = [1, 8]
nums2 = [0]
test_cases(nums1, nums2)"""

nums1 = [1]
nums2 = [9, 9]
test_cases(nums1, nums2)

nums1 = [5]
nums2 = [5]
test_cases(nums1, nums2)
