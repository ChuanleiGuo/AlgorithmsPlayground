#!/usr/bin/env python
# coding=utf-8
# Python使用的是2.7，缩进可以使用tab、4个空格或2个空格，但是只能任选其中一种，不能多种混用
while 1:
    s = raw_input()
    # raw_input()里面不要有任何提示信息
    if s != "":

        n = int(s)

        while n:

            x = int(raw_input())

            num_f = 0
            t = 1
            while t <= x:
                t *= 10
                num_f += 1

            sub = x - (t / 10) + 1

            l = 0
            for i in range(1, num_f):
                if i == 1:
                    l += i * ((i * 10 - 1) - ((i - 1) * 10))
                else:
                    l += i * ((i * 10 - 1) - ((i - 1) * 10) + 1)

            l += sub * len(str(x))

            print l

            n -= 1
    else:
        break
