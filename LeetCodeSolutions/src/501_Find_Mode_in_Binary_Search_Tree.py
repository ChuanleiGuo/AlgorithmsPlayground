class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def __init__(self):
        self.prev = None
        self.max_count = 0
        self.key_count = 1

    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def traverse(tree_node, modes):
            if tree_node is None:
                return
            traverse(tree_node.left, modes)

            if self.prev is not None:
                if tree_node.val == self.prev:
                    self.key_count += 1
                else:
                    self.key_count = 1
            
            if self.key_count > self.max_count:
                self.max_count = self.key_count
                modes[:] = []
                modes.append(tree_node.val)
            elif self.key_count == self.max_count:
                modes.append(tree_node.val)
            
            self.prev = tree_node.val
            traverse(tree_node.right, modes)

        if root is None:
            return []
        
        res = []
        traverse(root, res)
        return res

