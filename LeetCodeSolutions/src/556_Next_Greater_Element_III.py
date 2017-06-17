class Solution(object):
    def nextGreaterElement(self, n):
        """
        :type n: int
        :rtype: int
        """
        number = list(str(n))
        right_idx = len(number) - 1
        
        for i in range(len(number) - 1, -1, -1):
            if number[i - 1] < number[i]:
                break
        
        if i == 0:
            return -1

        x = number[i - 1]
        smallest = i
        for j in range(i + 1, len(number)):
            if number[j] > x and number[j] <= number[smallest]:
                smallest = j

        number[i - 1], number[smallest] = number[smallest], number[i - 1]

        number[i:] = sorted(number[i: len(number)])

        val = int(''.join(number))
        return val if val < 2 ** 31 - 1 else -1
        