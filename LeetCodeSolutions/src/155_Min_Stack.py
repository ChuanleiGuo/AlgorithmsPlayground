class MinStack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.__stack = []
        self.__min_element = 2 ** 31 - 1

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.__stack.append(x)
        self.__min_element = min(self.__min_element, x)

    def pop(self):
        """
        :rtype: void
        """
        r = self.__stack.pop(-1)
        if r == self.__min_element:
            if len(self.__stack) == 0:
                self.__min_element = 2 ** 31 - 1
            else:
                self.__min_element = min(self.__stack)

    def top(self):
        """
        :rtype: int
        """
        return self.__stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.__min_element