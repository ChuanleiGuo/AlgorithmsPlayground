class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        
        def is_same(sub1, sub2):
            if sub1 is None and sub2 is None:
                return True
            if sub1 is None or sub2 is None:
                return False
            
            if sub1.val != sub2.val:
                return False
            
            return is_same(sub1.left, sub2.left) and \
                   is_same(sub1.right, sub2.right)

        if s is None:
            return False
        if is_same(s, t):
            return True
        
        return self.isSubtree(s.left, t) or self.isSubtree(s.right, t)
