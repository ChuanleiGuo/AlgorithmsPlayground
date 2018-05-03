import re


class Solution:
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        (a1, b1) = self.parseSide(equation.split('=')[0])
        (a2, b2) = self.parseSide(equation.split('=')[1])

        if a1 == a2 and b1 != b2:
            return "No solution"
        elif a1 == a2 and b1 == b2:
            return "Infinite solutions"
        else:
            return "x=" + str(int((b2 - b1) / (a1 - a2)))

    def parseSide(self, exp):
        tokens = re.findall("[+-]?[0-9]*x?", exp)

        a, b = 0, 0
        for token in tokens:
            if token == "x" or token == "+x":
                a += 1
            elif token == "-x":
                a -= 1
            elif "x" in token:
                a += int(token[:-1])
            elif len(token) > 0:
                b += int(token)
        return a, b
