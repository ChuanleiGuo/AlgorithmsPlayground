class Solution(object):
    def maximumGap(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length < 2:
            return 0
        bound_x = min(nums)
        bound_y = max(nums)
        bucket_range = max(1, int((bound_y - bound_x - 1) / (length - 1)) + 1)
        bucket_len = (bound_y - bound_x) / bucket_range + 1
        buckets = [None] * bucket_len
        for k in nums:
            loc = (k - bound_x) / bucket_range
            bucket = buckets[loc]
            if bucket is None:
                bucket = {'min': k, 'max': k}
                buckets[loc] = bucket
            else:
                bucket['min'] = min(bucket['min'], k)
                bucket['max'] = max(bucket['max'], k)

        max_gap = 0
        for x in range(bucket_len):
            if buckets[x] is None:
                continue
            y = x + 1
            while y < bucket_len and buckets[y] is None:
                y += 1
            if y < bucket_len:
                max_gap = max(max_gap, buckets[y]['min'] - buckets[x]['max'])
            x = y
        return max_gap