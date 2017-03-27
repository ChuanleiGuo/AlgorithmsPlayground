class SegmentTreeNode(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.left = None
        self.right = None
        self.sum = 0


class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.root = self.__buildTree(nums, 0, len(nums) - 1)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: int
        """
        self.__update(self.root, i, val)

    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.__sumRange(self.root, i, j)

    def __buildTree(self, nums, start, end):
        if start > end:
            return None
        else:
            ret = SegmentTreeNode(start, end)
            if start == end:
                ret.sum = nums[start]
            else:
                mid = start + (end - start) / 2
                ret.left = self.__buildTree(nums, start, mid)
                ret.right = self.__buildTree(nums, mid + 1, end)
                ret.sum = ret.left.sum + ret.right.sum
            return ret

    def __update(self, root, pos, val):
        if root.start == root.end:
            root.sum = val
        else:
            mid = root.start + (root.end - root.start) / 2
            if pos <= mid:
                self.__update(root.left, pos, val)
            else:
                self.__update(root.right, pos, val)
            root.sum = root.left.sum + root.right.sum

    def __sumRange(self, root, start, end):
        if root.end == end and root.start == start:
            return root.sum
        else:
            mid = root.start + (root.end - root.start) / 2
            if end <= mid:
                return self.__sumRange(root.left, start, end)
            elif start >= mid + 1:
                return self.__sumRange(root.right, start, end)
            else:
                return self.__sumRange(root.left, start, mid) + \
                       self.__sumRange(root.right, mid + 1, end)
