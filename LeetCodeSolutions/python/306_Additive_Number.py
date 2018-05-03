class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        def isAdditive(string, num1, num2):
            if string == '':
                return True

            s = num1 + num2
            s_str = str(s)
            if not string.startswith(s_str):
                return False
            return isAdditive(string[len(s_str):], num2, s)

        length = len(num)
        for i in range(1, (length - 1) / 2 + 1):
            if num[0] == '0' and i >= 2:
                break

            j = i + 1
            while (length - j) >= max(j - i, i):
                if num[i] == '0' and j - i >= 2:
                    break

                num1 = int(num[0: i])
                num2 = int(num[i: j])
                sub_str = num[j:]

                if isAdditive(sub_str, num1, num2):
                    return True

                j += 1

        return False
