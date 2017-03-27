from collections import OrderedDict

class LFUCache(object):
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.value_dict = {}
        self.node_dict = {}
        self.head = None

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.value_dict:
            self.__increase_count(key)
            return self.value_dict[key]
        return -1

    def __increase_count(self, key):
        node = self.node_dict[key]
        del node.keys[key]

        if node.next is None:
            node.next = self.Node(node.count + 1)
            node.next.prev = node
            node.next.keys[key] = None
        elif node.next.count == node.count + 1:
            node.next.keys[key] = None
        else:
            tmp = self.Node(node.count + 1)
            tmp.keys[key] = None
            tmp.prev = node
            tmp.next = node.next
            node.next.prev = tmp
            node.next = tmp

        self.node_dict[key] = node.next
        if len(node.keys) == 0:
            self.__remove(node)

    def __remove_old(self):
        if not self.head:
            return
        old = 0
        for n in self.head.keys.keys():
            old = n
            break
        del self.head.keys[old]
        if len(self.head.keys) == 0:
            self.__remove(self.head)
        del self.node_dict[old]
        del self.value_dict[old]

    def __remove(self, node):
        if node.prev is None:
            self.head = node.next
        else:
            node.prev.next = node.next;
        if node.next:
            node.next.prev = node.prev

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if self.capacity == 0:
            return
        if key in self.value_dict:
            self.value_dict[key] = value
        else:
            if len(self.value_dict) < self.capacity:
                self.value_dict[key] = value
            else:
                self.__remove_old()
                self.value_dict[key] = value
            self.__add_to_head(key)
        self.__increase_count(key)

    def __add_to_head(self, key):
        if self.head is None:
            self.head = self.Node(0)
            self.head.keys[key] = None
        elif self.head.count > 0:
            node = self.Node(0)
            node.keys[key] = None
            node.next = self.head
            self.head.prev = node
            self.head = node
        else:
            self.head.keys[key] = None
        self.node_dict[key] = self.head

    class Node:
        def __init__(self, count):
            self.count = count
            self.keys = OrderedDict()
            self.prev = None
            self.next = None
