class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        count = []
        res = []
        i = 0
        res.append('')
        while i < len(s):
            if str.isdigit(s[i]):
                start = i
                while str.isdigit(s[i + 1]):
                    i += 1
                count.append(int(s[start: i + 1]))
            elif s[i] == '[':
                res.append('')
            elif s[i] == ']':
                temp = res.pop()
                string = ""
                times = count.pop()
                for j in range(times):
                    string += temp
                res.append(res.pop() + string)
            else:
                res.append(res.pop() + s[i])
            i += 1
        return res.pop()

print Solution().decodeString("3[a]2[bc]")
