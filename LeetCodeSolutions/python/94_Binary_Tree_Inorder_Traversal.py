class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    # recursively
    # def inorderTraversal(self, root):
    #     """
    #     :type root: TreeNode
    #     :rtype: List[int]
    #     """
    #     def inorder(root_nood):
    #         if root_nood is None:
    #             return
    #         inorder(root_nood.left)
    #         result.append(root_nood.val)
    #         inorder(root_nood.right)
    #
    #     result = []
    #     inorder(root)
    #     return result
    # iteratively
    class Solution(object):
        def inorderTraversal(self, root):
            """
            :type root: TreeNode
            :rtype: List[int]
            """
            stack = []
            res = []
            while True:
                while root is not None:
                    stack.append(root)
                    root = root.left
                if len(stack) == 0:
                    break
                node = stack.pop()
                res.append(node.val)
                root = node.right
            return res
