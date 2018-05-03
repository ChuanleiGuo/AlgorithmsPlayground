class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def is_valid(s):
            ctr = 0
            for c in s:
                if c == '(':
                    ctr += 1
                elif c == ')':
                    ctr -= 1
                    if ctr < 0:
                        return False
            return ctr == 0

        level = {s}
        while True:
            valid = filter(is_valid, level)
            if valid:
                return valid
            level = {s[:i] + s[i + 1:] for s in level for i in range(len(s))}
