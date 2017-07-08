class Solution:
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        a_index = {u: i for i, u in enumerate(list1)}
        best, ans = 1e9, []

        for j, v in enumerate(list2):
            i = a_index.get(v, 1e9)
            if i + j < best:
                ans = [v]
                best = i + j
            elif i + j == best:
                ans.append(v)
        return ans
