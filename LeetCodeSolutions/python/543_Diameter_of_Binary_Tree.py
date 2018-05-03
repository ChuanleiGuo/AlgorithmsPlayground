class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __init__(self):
        self._diameter = 0
    
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """

        def max_depth(node):
            if node is None:
                return 0
            left = max_depth(node.left)
            right = max_depth(node.right)
            self._diameter = max(self._diameter, left + right)
            return max(left, right) + 1
        
        max_depth(root)
        
        return self._diameter