class Solution(object):
    def countRangeSum(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        n = len(nums)
        sums = [0] * (n + 1)
        for i in range(0, n):
            sums[i + 1] = sums[i] + nums[i]
        return self.count_while_merge_sort(sums, 0, n + 1, lower, upper)

    def count_while_merge_sort(self, sums, start, end, lower, upper):
        if end - start <= 1:
            return 0
        mid = start + (end - start) / 2
        count = self.count_while_merge_sort(sums, start, mid, lower, upper) + \
            self.count_while_merge_sort(sums, mid, end, lower, upper)
        j = k = t = mid
        cache = [0] * (end - start)

        r = 0
        for i in range(start, mid):
            while k < end and sums[k] - sums[i] < lower:
                k += 1
            while j < end and sums[j] - sums[i] <= upper:
                j += 1
            while t < end and sums[t] < sums[i]:
                cache[r] = sums[t]
                r += 1
                t += 1
            cache[r] = sums[i]
            count += j - k
            r += 1

        j = 0
        for i in range(start, t):
            sums[i] = cache[j]
            j += 1
        return count

print Solution().countRangeSum([-2, 5, -1], -2, 2)
