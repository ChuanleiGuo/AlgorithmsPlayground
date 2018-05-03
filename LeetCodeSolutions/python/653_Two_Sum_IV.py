class Solution:
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        nums = []
        self.inorder(root, nums)
        i, j = 0, len(nums) - 1
        while i < j:
            if nums[i] + nums[j] == k:
                return True
            if nums[i] + nums[j] < k:
                i += 1
            else:
                j -= 1
        return False

    def inorder(self, root, nums):
        if root is None:
            return
        self.inorder(root.left, nums)
        nums.append(root.val)
        self.inorder(root.right, nums)