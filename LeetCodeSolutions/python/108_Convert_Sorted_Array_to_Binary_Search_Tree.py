class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        def build_tree(start, end):
            if start > end:
                return None

            mid = int((start + end) / 2)
            root = TreeNode(nums[mid])
            root.left = build_tree(start, mid - 1)
            root.right = build_tree(mid + 1, end)
            return root

        if nums is None or len(nums) == 0:
            return None
        return build_tree(0, len(nums) - 1)
