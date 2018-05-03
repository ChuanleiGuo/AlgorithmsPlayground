class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        buckets = [[] for _ in range(len(nums) + 1)]
        frequency_dict = {}
        for num in nums:
            frequency_dict[num] = frequency_dict.get(num, 0) + 1

        for key in frequency_dict.keys():
            frequency = frequency_dict[key]
            buckets[frequency].append(key)

        res = []
        pos = len(buckets) - 1
        while len(res) < k and pos >= 0:
            if len(buckets[pos]) > 0:
                res += buckets[pos]
            pos -= 1

        return res
