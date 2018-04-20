#!/usr/bin/env python
# coding=utf-8
# Python使用的是2.7，缩进可以使用tab、4个空格或2个空格，但是只能任选其中一种，不能多种混用

from fractions import gcd

def make_arr(start, num):
    l = [0, start]
    for i in range(2, num + 1):
        l.append((l[i - 1] + 153) % start)
    return l

while 1:
    arr = []
    s = raw_input()
    # raw_input()里面不要有任何提示信息
    if s != "":
        for x in s.split():
            arr.append(int(x))

        N, n, m, p = arr[0], arr[1], arr[2], arr[3]

        nums = make_arr(p, N)

        res = 0
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                res += nums[gcd(i, j)]

        print res
    else:
        break
