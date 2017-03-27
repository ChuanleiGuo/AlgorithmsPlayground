class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        # recursively
        # if root is None:
        #     return False
        # if not root.left and not root.right:
        #     return root.val == sum
        # return self.hasPathSum(root.left, sum - root.val) or \
        #     self.hasPathSum(root.right, sum - root.val)

        # iteratively
        if root is None:
            return False
        if not root.left and not root.right:
            return root.val == sum

        stack = [(root, root.val)]
        while len(stack) != 0:
            temp, val = stack.pop()
            if not temp.left and not temp.right and val == sum:
                return True
            if temp.left:
                stack.append((temp.left, val + temp.left.val))
            if temp.right:
                stack.append((temp.right, val + temp.right.val))
        return False
