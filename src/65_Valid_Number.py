class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.strip()
        length = len(s)
        if length == 0:
            return False

        has_e = has_first = has_dot = has_digit = False

        for c in s:
            if c.isdigit():
                has_first = has_digit = True
                continue

            if c == "e":
                if has_e or not has_digit:
                    return False
                has_e = True
                has_first = has_digit = False
                has_dot = True
                continue
            elif c in ("+", "-"):
                if has_first:
                    return False
                has_first = True
                continue
            elif c == ".":
                if has_dot:
                    return False
                has_first = has_dot = True
                continue
            else:
                return False

        return has_digit
