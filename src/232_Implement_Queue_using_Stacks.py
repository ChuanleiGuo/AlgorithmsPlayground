class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.pusher = []
        self.popper = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.pusher.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if not self.popper:
            while self.pusher:
                self.popper.append(self.pusher.pop())
        self.popper.pop()

    def peek(self):
        """
        :rtype: int
        """
        if self.popper:
            return self.popper[-1]
        return self.pusher[0]

    def empty(self):
        """
        :rtype: bool
        """
        return len(self.popper) == 0 and len(self.pusher) == 0
