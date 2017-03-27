class Iterator(object):
    def __init__(self, nums):
        """
        Initializes an iterator object to the beginning of a list.
        :type nums: List[int]
        """
        pass

    def hasNext(self):
        """
        Returns true if the iteration has more elements.
        :rtype: bool
        """
        return True

    def next(self):
        """
        Returns the next element in the iteration.
        :rtype: int
        """
        return 0


class PeekingIterator(object):
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.__iter = iterator
        self.__next = self.__iter.next() if self.__iter.hasNext() else None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        return self.__next

    def next(self):
        """
        :rtype: int
        """
        res = self.__next
        self.__next = self.__iter.next() if self.__iter.hasNext() else None
        return res

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.__next is not None
