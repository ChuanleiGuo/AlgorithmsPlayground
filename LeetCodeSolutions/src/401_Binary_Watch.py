class Solution(object):
    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        res = []
        nums1 = [8, 4, 2, 1]
        nums2 = [32, 16, 8, 4, 2, 1]
        for i in xrange(0, num + 1):
            l1 = self.generate_digit(nums1, i)
            l2 = self.generate_digit(nums2, num - i)
            for num1 in l1:
                if num1 >= 12:
                    continue
                for num2 in l2:
                    if num2 >= 60:
                        continue
                    res.append("%d:%02d" % (num1, num2))
        return res

    def generate_digit(self, nums, count):
        res = []
        self.generate_digit_helper(nums, count, 0, 0, res)
        return res

    def generate_digit_helper(self, nums, count, pos, s, res):
        if count == 0:
            res.append(s)
            return

        for i in xrange(pos, len(nums)):
            self.generate_digit_helper(nums, count - 1, i + 1, s + nums[i], res)