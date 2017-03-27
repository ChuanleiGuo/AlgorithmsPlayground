class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        if not tokens or len(tokens) == 0:
            return 0

        result = 0
        stack = []
        for token in tokens:
            if token.isdigit():
                stack.append(int(token))
            elif len(token) >= 2 and (token[0] == '+' or token[0] == '-'):
                t = token[1:]
                if t.isdigit():
                    stack.append(int(token))
            else:
                opd1 = stack.pop()
                opd2 = stack.pop()
                if token == '+':
                    result = opd1 + opd2
                elif token == '-':
                    result = opd2 - opd1
                elif token == '*':
                    result = opd1 * opd2
                elif token == '/':
                    result = int(float(opd2) / opd1)
                stack.append(result)
        return stack.pop()
