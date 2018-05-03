# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
class NestedInteger(object):
    def __init__(self, value=None):
        """
        If value is not specified, initializes an empty list.
        Otherwise initializes a single integer equal to value.
        """
        pass

    def isInteger(self):
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        :rtype bool
        """
        return False

    def add(self, elem):
        """
        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
        :rtype void
        """
        pass

    def setInteger(self, value):
        """
        Set this NestedInteger to hold a single integer equal to value.
        :rtype void
        """
        pass

    def getInteger(self):
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        :rtype int
        """
        return 0

    def getList(self):
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        :rtype List[NestedInteger]
        """
        return []


class Solution(object):
    def deserialize(self, s):
        """
        :type s: str
        :rtype: NestedInteger
        """
        if len(s) == 0:
            return False
        if s[0] != '[':
            return NestedInteger(int(s))

        stack = []
        curr = None
        l = 0
        for r in xrange(len(s)):
            ch = s[r]
            if ch == '[':
                if curr is not None:
                    stack.append(curr)
                curr = NestedInteger()
                l = r + 1
            elif ch == ']':
                num = s[l: r]
                if len(num) > 0:
                    curr.add(NestedInteger(int(num)))
                if len(stack) > 0:
                    pop = stack.pop()
                    pop.add(curr)
                    curr = pop
                l = r + 1
            elif ch == ',':
                if s[r - 1] != ']':
                    num = s[l: r]
                    curr.add(NestedInteger(int(num)))
                l = r + 1
        return curr
