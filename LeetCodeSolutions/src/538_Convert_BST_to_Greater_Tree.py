class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        def reverse_inorder(node, val):
            if node is None:
                return val
            right = reverse_inorder(node.right, val)
            left = reverse_inorder(node.left, node.val + right)
            node.val += right
            return left
        
        reverse_inorder(root, 0)
        return root
