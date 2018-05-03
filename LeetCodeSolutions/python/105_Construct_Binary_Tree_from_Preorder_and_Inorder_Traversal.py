class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        def build_tree(idx, end, start):
            if idx >= len(preorder) or start > end:
                return None
            root = TreeNode(preorder[idx])

            i = end
            while i >= start:
                if preorder[idx] == inorder[i]:
                    break
                i -= 1

            root.left = build_tree(idx + 1, i - 1, start)
            root.right = build_tree(idx + i - start + 1, end, i + 1)
            return root

        return build_tree(0, len(inorder) - 1, 0)
