class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        string = '1'
        for i in range(2, n + 1):
            j = 0
            temp = ''
            while j < len(string):
                k = j + 1
                while k in range(j + 1, len(string)):
                    if string[k] != string[j]:
                        break
                    k += 1
                temp += str(k - j)
                temp += str(string[j])
                j = k
            string = temp
        return string

n = 2
print Solution().countAndSay(n)
