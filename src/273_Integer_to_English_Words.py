class Solution(object):

    def __init__(self):
        self.below_ten = {0: "", 1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five",
                          6: "Six", 7: "Seven", 8: "Eight", 9: "Nine"}
        self.below_twenty = {0: "Ten", 1: "Eleven", 2: "Twelve", 3: "Thirteen", 4: "Fourteen",
                             5: "Fifteen", 6: "Sixteen", 7: "Seventeen", 8: "Eighteen", 9: "Nineteen"}
        self.below_hundred = {0: "", 1: "Ten", 2: "Twenty", 3: "Thirty", 4: "Forty", 5: "Fifty",
                              6: "Sixty", 7: "Seventy", 8: "Eighty", 9: "Ninety"}

    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "Zero"
        return self.helper(num)

    def helper(self, num):
        res = ""
        if num < 10:
            res = self.below_ten[num]
        elif num < 20:
            res = self.below_twenty[num - 10]
        elif num < 100:
            res = self.below_hundred[num / 10] + " " + self.helper(num % 10)
        elif num < 1000:
            res = self.helper(num / 100) + " Hundred " + self.helper(num % 100)
        elif num < 1000000:
            res = self.helper(num / 1000) + " Thousand " + self.helper(num % 1000)
        elif num < 1000000000:
            res = self.helper(num / 1000000) + " Million " + self.helper(num % 1000000)
        else:
            res = self.helper(num/1000000000) + " Billion " + self.helper(num % 1000000000)

        return res.strip()
