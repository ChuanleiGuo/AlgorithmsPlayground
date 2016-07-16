class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        if numerator == 0:
            return "0"

        res = []
        res.append('-' if (numerator > 0) ^ (denominator > 0) else '')

        num = abs(numerator)
        den = abs(denominator)

        res.append(str(num / den))
        num %= den
        if num == 0:
            return ''.join(res)

        res.append('.')
        hashmap = {}
        while num != 0:
            hashmap[num] = len(res)

            num *= 10
            res.append(str(num / den))
            num %= den

            reminder_index = hashmap.get(num, None)
            if reminder_index:
                res.insert(reminder_index, '(')
                res.append(')')
                break

        return ''.join(res)
