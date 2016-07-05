from collections import OrderedDict


class LRUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.size = capacity
        self.cache = OrderedDict()

    def get(self, key):
        """
        :rtype: int
        """
        val = self.cache.pop(key, default=None)
        if val is None:
            return -1
        self.cache[key] = val
        return val

    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if self.cache.pop(key, default=None) is None \
                and len(self.cache) == self.size:
            self.cache.popitem(last=False)
        self.cache[key] = value
