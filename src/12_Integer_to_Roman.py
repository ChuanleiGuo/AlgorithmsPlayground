class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        result = ""
        keys = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
        i = 0
        while num != 0:
            while num >= values[i]:
                num -= values[i]
                result += keys[i]
            i += 1
        return result

print Solution().intToRoman(900)
print Solution().intToRoman(90)
print Solution().intToRoman(9)
print Solution().intToRoman(45)
print Solution().intToRoman(50)
print Solution().intToRoman(55)
print Solution().intToRoman(77)
print Solution().intToRoman(98)
print Solution().intToRoman(6)
