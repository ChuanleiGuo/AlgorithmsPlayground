class Solution:
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node, level, order, start, end):
            if node is None:
                return 0
            if len(start) == level:
                start.append(order)
                end.append(order)
            else:
                end[level] = order
            cur = end[level] - start[level] + 1
            left = dfs(node.left, level + 1, 2 * order, start, end)
            right = dfs(node.right, level + 1, 2 * order + 1, start, end)

            return max(cur, left, right)
        
        return dfs(root, 0, 1, [], [])
