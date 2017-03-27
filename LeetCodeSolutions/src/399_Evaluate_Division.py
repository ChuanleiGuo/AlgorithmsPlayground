class Solution(object):
    def calcEquation(self, equations, values, queries):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type queries: List[List[str]]
        :rtype: List[float]
        """
        key_pairs = {}
        value_pairs = {}
        for i in xrange(len(equations)):
            equation = equations[i]
            if equation[0] not in key_pairs:
                key_pairs[equation[0]] = []
                value_pairs[equation[0]] = []
            if equation[1] not in value_pairs:
                key_pairs[equation[1]] = []
                value_pairs[equation[1]] = []

            key_pairs[equation[0]].append(equation[1])
            key_pairs[equation[1]].append(equation[0])
            value_pairs[equation[0]].append(values[i])
            value_pairs[equation[1]].append(1.0 / values[i])

        res = []
        for query in queries:
            r = self.dfs(query[0], query[1], key_pairs, value_pairs, set(), 1.0)
            if r == 0.0:
                res.append(-1.0)
            else:
                res.append(r)
        return res

    def dfs(self, start, end, key_pairs, value_pairs, mid_set, value):
        if start in mid_set:
            return 0.0
        if start not in key_pairs:
            return 0.0
        if start == end:
            return value
        mid_set.add(start)

        str_list = key_pairs[start]
        value_list = value_pairs[start]
        temp = 0.0
        for i in xrange(len(str_list)):
            temp = self.dfs(str_list[i], end, key_pairs, value_pairs,
                            mid_set, value * value_list[i])
            if temp != 0.0:
                break
        mid_set.remove(start)
        return temp
