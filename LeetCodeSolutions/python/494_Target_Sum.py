class Solution(object):

    def findTargetSumWays(self, nums, s):
        """
        :type nums: List[int]
        :type s: int
        :rtype: int
        """
        def dfs(array, idx, sum_arr, target, hash_map):
            encode_str = str(idx) + "->" + str(sum_arr)
            if encode_str in hash_map:
                return hash_map[encode_str]
            if idx == len(array):
                if sum_arr == target:
                    return 1
                else:
                    return 0

            cur_num = array[idx]
            add_sum = dfs(array, idx + 1, sum_arr + cur_num, target, hash_map)
            sub_sum = dfs(array, idx + 1, sum_arr - cur_num, target, hash_map)
            hash_map[encode_str] = add_sum + sub_sum
            return add_sum + sub_sum

        if not nums or len(nums) == 0:
            return 0
        return dfs(nums, 0, 0, s, {})
