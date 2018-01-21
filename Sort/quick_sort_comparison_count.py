from __future__ import print_function

def choose_pivot_first(lst):
    return 0

def choose_pivot_last(lst):
    return len(lst) - 1

def choose_pivot_random(lst):
    from random import randrange
    return randrange(0, stop=len(lst))

def choose_pivot_median(lst):
    left, right = 0, len(lst) - 1
    mid_index = left + (right - left) / 2
    tmp_lst = sorted([lst[left], lst[mid_index], lst[right]])
    return lst.index(tmp_lst[1])

def partition(lst, pivot):
    if lst[0] != lst[pivot]:
        lst[0], lst[pivot] = lst[pivot], lst[0]
    i = 1
    for j in range(1, len(lst)):
        if lst[j] < lst[0]:
            lst[i], lst[j] = lst[j], lst[i]
            i += 1
    lst[0], lst[i - 1] = lst[i - 1], lst[0]
    return lst[: i - 1], lst[i: ]

def quick_sort(lst, choose_pivot_func):
    num_comparison = len(lst) - 1
    if len(lst) <= 1:
        return lst, 0
    pivot = choose_pivot_func(lst)
    p_val = lst[pivot]
    less_part, greater_part = partition(lst, pivot)
    result1 = quick_sort(less_part, choose_pivot_func)
    result2 = quick_sort(greater_part, choose_pivot_func)
    return result1[0] + [p_val] + result2[0], num_comparison + result1[1] + result2[1]

txt10 = map(lambda num: int(num.strip()), open("10.txt").read().split("\n")[:-1])
assert quick_sort(list(txt10), choose_pivot_first)[1] == 25
assert quick_sort(list(txt10), choose_pivot_last)[1] == 29
assert quick_sort(list(txt10), choose_pivot_median)[1] == 21

txt100 = map(lambda num: int(num.strip()), open("100.txt").read().split("\n")[:-1])
assert  quick_sort(list(txt100), choose_pivot_first)[1] == 615
assert  quick_sort(list(txt100), choose_pivot_last)[1] == 587
assert  quick_sort(list(txt100), choose_pivot_median)[1] == 518

txt1000 = map(lambda num: int(num.strip()), open("1000.txt").read().split("\n")[:-1])
assert quick_sort(list(txt1000), choose_pivot_first)[1] == 10297
assert quick_sort(list(txt1000), choose_pivot_last)[1] == 10184
assert quick_sort(list(txt1000), choose_pivot_median)[1] == 8921

from random import shuffle
test1_list = [2,34,4,4,43,3,3,2,3,2]
assert quick_sort(test1_list, choose_pivot_first)[0] == sorted(test1_list)
assert quick_sort(test1_list, choose_pivot_last)[0] == sorted(test1_list)
assert quick_sort(test1_list, choose_pivot_random)[0] == sorted(test1_list)
assert quick_sort(test1_list, choose_pivot_median)[0] == sorted(test1_list)
test2_list = [32432,3,32,2134249,435,43,3,-1,0,435,2,1,594,94,2,-90,-3,1]
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)
shuffle(test2_list)
assert quick_sort(test2_list, choose_pivot_first)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_last)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_random)[0] == sorted(test2_list)
assert quick_sort(test2_list, choose_pivot_median)[0] == sorted(test2_list)

inp_lst = open("QuickSort.txt").read().split("\n")[:-1]
inp_lst = list(map(lambda num: int(num.strip()), inp_lst))
print("number of elements:", len(inp_lst))
print("choose_pivot_first:",  quick_sort(inp_lst, choose_pivot_first)[1])
print("choose_pivot_last:",  quick_sort(inp_lst, choose_pivot_last)[1])
print("choose_pivot_median:",  quick_sort(inp_lst, choose_pivot_median)[1])
print("choose_pivot_random:",  quick_sort(inp_lst, choose_pivot_random)[1])

assert choose_pivot_median([4, 5, 6, 7]) == 1
assert choose_pivot_median([8, 2, 4, 5, 7, 1]) == 2
assert choose_pivot_median([8, 2, 4, 5, 5, 7, 1]) == 3
