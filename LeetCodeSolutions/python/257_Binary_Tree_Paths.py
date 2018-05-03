class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):

        def search_path(node, path, r):
            if not node.left and not node.right:
                r.append(path + str(node.val))
            if node.left:
                search_path(node.left, path + str(node.val) + '->', r)
            if node.right:
                search_path(node.right, path + str(node.val) + '->', r)

        res = []
        if root:
            search_path(root, '', res)
        return res

