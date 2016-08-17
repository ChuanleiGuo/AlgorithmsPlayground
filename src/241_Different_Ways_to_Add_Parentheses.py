class Solution(object):

    res_map = {}

    def diffWaysToCompute(self, input_str):
        """
        :type input_str: str
        :rtype: List[int]
        """
        res = []
        for i in range(len(input_str)):
            if input_str[i] == '+' or input_str[i] == '-'\
                    or input_str[i] == '*':
                part1 = input_str[:i]
                part2 = input_str[i + 1:]
                part1_res = self.res_map.get(part1, self.diffWaysToCompute(part1))
                part2_res = self.res_map.get(part2, self.diffWaysToCompute(part2))

                for p1 in part1_res:
                    for p2 in part2_res:
                        c = 0
                        if input_str[i] == '+':
                            c = p1 + p2
                        elif input_str[i] == '-':
                            c = p1 - p2
                        elif input_str[i] == '*':
                            c = p1 * p2
                        res.append(c)

        if len(res) == 0:
            res.append(int(input_str))

        self.res_map[input_str] = res

        return res
