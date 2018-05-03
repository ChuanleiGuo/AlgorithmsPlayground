class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if not t:
            return ""

        res = str(t.val)
        left = self.tree2str(t.left)
        right = self.tree2str(t.right)

        if left == "" and right == "":
            return res
        if left == "":
            return res + "()" + '(' + right + ')'
        if right == "":
            return res + '(' + left + ')'
        return res + '(' + left + ')' + '(' + right + ')'
