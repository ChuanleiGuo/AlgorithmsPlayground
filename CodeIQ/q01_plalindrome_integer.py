# 
# 问题：求用十进制、二进制、八进制表示的都是回文数的所有数字中，大于十进制数10的最小值。
#
# 思路：在二进制表示中，如果最低位数字为0，那么回文表示的最高位也是0，然而最高位不能为0，
#      所以，最低位一定为1，那么这个数一定为基数。
# 
# 解法：从 11 开始判断每个奇数，直到满足要求。
#

def plalindrome_integer():
    num = 585
    while True:
        if bin(num)[2:] == ''.join(reversed(bin(num)))[0:-2] and \
           oct(num)[2:] == ''.join(reversed(oct(num)))[0:-2] and \
           str(num) == ''.join(reversed(str(num))):

            return num
            
        num += 2

print(plalindrome_integer())
