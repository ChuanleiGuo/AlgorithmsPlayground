class Node(object):
    def __init__(self, v, s):
        self.left = None
        self.right = None
        self.val = v
        self.sum = s
        self.dup = 1


class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = [0] * len(nums)
        root = None
        for i in range(len(nums) - 1, -1, -1):
            root = self.insert(nums[i], root, ans, i, 0)
        return ans

    def insert(self, num, node, ans, i, pre_sum):
        if node is None:
            node = Node(num, 0)
            ans[i] = pre_sum
        elif node.val == num:
            node.dup += 1
            ans[i] = pre_sum + node.sum
        elif node.val > num:
            node.sum += 1
            node.left = self.insert(num, node.left, ans, i, pre_sum)
        else:
            node.right = self.insert(num, node.right, ans, i,
                                     pre_sum + node.dup + node.sum)

        return node
