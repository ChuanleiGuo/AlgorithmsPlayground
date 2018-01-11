def count_split_invertion(l1, l2):
    i, j, count = 0, 0, 0
    result = []
    while i < len(l1) and j < len(l2):
        if l1[i] <= l2[j]:
            result.append(l1[i])
            i += 1
        else:
            result.append(l2[j])
            count += len(l1[i:])
            j += 1
    if i < len(l1):
        result += l1[i:]
    if j < len(l2):
        result += l2[j:]
    return result, count

def divide_conquer_invertion(l):
    length = len(l)
    if length < 2:
        return l, 0
    left_l, left_count = divide_conquer_invertion(l[: length / 2])
    right_l, right_count = divide_conquer_invertion(l[length / 2 :])
    l_merged, split_count = count_split_invertion(left_l, right_l)
    return l_merged, left_count + right_count + split_count

assert divide_conquer_invertion([1,3,5,2,4,6])[1] == 3
assert divide_conquer_invertion([6,5,4,3,2,1])[1] == 15
assert divide_conquer_invertion([1,3,5,6])[1] == 0

f = open("IntegerArray.txt")
lst = []
for line in f:
    lst.append(int(line))

print "answer"
print divide_conquer_invertion(lst)[1]
