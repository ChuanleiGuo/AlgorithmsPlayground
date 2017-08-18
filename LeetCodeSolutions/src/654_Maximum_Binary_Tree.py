class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def build_tree(start, end):
            if start > end:
                return None

            idx_max = nums.index(max(nums[start:end+1]))
            root = TreeNode(nums[idx_max])

            root.left = build_tree(start, idx_max - 1)
            root.right = build_tree(idx_max + 1, end)
            return root

        return build_tree(0, len(nums) - 1)
