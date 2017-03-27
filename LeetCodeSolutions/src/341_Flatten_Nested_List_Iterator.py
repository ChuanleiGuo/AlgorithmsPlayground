class NestedInteger(object):
    def isInteger(self):
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        :rtype bool
        """
        pass

    def getInteger(self):
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        :rtype
        int
        """
        pass

    def getList(self):
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        :rtype List[NestedInteger]
        """
        pass


class NestedIterator(object):
    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.stack = [[nestedList, 0]]

    def next(self):
        """
        :rtype: int
        """
        self.hasNext()
        nested_list, i = self.stack[-1]
        self.stack[-1][1] += 1
        return nested_list[i].getInteger()

    def hasNext(self):
        """
        :rtype: bool
        """
        s = self.stack
        while s:
            nested_list, i = s[-1]
            if i == len(nested_list):
                s.pop()
            else:
                x = nested_list[i]
                if x.isInteger():
                    return True
                s[-1][1] += 1
                s.append([x.getList(), 0])
        return False
