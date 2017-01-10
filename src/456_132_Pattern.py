class Solution(object):
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        e3, st = float("-inf"), []

        for e in reversed(nums):
            if e < e3:
                return True
            while st and e > st[-1]:
                e3 = st.pop()
            st.append(e)
        return False
