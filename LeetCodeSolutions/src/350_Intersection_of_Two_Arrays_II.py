class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        dic = dict()
        res = []
        for v in nums1:
            if v not in dic:
                dic[v] = [1,0]
            else:
                dic[v][0] += 1
        for v in nums2:
            if v in dic:
                dic[v][1] += 1
        for k,v in dic.items():
            if v[0]*v[1] > 0:
                for i in range(min(v[0],v[1])):
                    res.append(k)
        return res