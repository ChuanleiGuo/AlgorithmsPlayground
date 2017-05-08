from collections import Counter

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def findFrequentTreeSum(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        def cal_sum(node):
            if node is None:
                return 0
            s = node.val + cal_sum(node.left) + cal_sum(node.right)
            counter[s] += 1
            return s
        counter = Counter()
        cal_sum(root)
        highest_freq = max(counter.values())
        return [key for key in counter.keys() if counter[key] == highest_freq]
