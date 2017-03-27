class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        def build_tree(lin, rin):
            if lin < rin:
                root = TreeNode(postorder.pop(-1))
                root_idx = indict[root.val]
                root.right = build_tree(root_idx + 1, rin)
                root.left = build_tree(lin, root_idx)
                return root

        indict = {val: i for i, val in enumerate(inorder)}
        return build_tree(0, len(postorder))
