class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        res = []
        self.subtree_serial(root, dict(), res)
        return res

    def subtree_serial(self, cur, hash_map, res):
        if cur is None:
            return '#'
        serial = str(cur.val) + ',' + self.subtree_serial(cur.left, hash_map, res) + ',' + \
            self.subtree_serial(cur.right, hash_map, res)
        if hash_map.get(serial, 0) == 1:
            res.append(cur)
        hash_map[serial] = hash_map.get(serial, 0) + 1
        return serial
