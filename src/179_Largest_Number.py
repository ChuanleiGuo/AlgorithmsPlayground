class Solution:
    # @param {integer[]} nums
    # @return {string}
    def largestNumber(self, nums):
        arr = map(str, nums)
        arr = sorted(arr, cmp=lambda x, y: int(y + x) - int(x + y))
        res = "".join(arr)
        return res if res[0] != '0' else '0'
