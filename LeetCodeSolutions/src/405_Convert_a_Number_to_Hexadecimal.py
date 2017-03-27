class Solution(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        def rshift(val, n):
            return val >> n if val >= 0 else (val + 0x100000000) >> n

        num_hex_pair = ['0', '1', '2', '3', '4', '5', '6', '7',
                        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
        if num == 0:
            return '0'

        res = ""
        while num:
            res = num_hex_pair[num & 0xf] + res
            num = rshift(num, 4)
        return res
