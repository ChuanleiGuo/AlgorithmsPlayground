def ChoosePivot(A,l,r):
    # m = (l+r-1)/2
    # mid = sorted([A[l],A[m],A[r-1]])[1]
    # if (A[l] == mid): return l
    # elif (A[m] == mid): return m
    # else: return r-1
    return r - 1

def Partition(A,l,r):
    p = A[l]
    i = l+1
    for j in range(l+1,r):
        if A[j] <= p:
            A[i], A[j] = A[j], A[i]
            i += 1
    A[l], A[i-1] = A[i-1], A[l]
    return i-1

def QuickSort(A,l,r):
    global count
    if r <= l: return
    p = ChoosePivot(A,l,r)
    A[p], A[l] = A[l], A[p]
    j = Partition(A,l,r)
    QuickSort(A,l,j)
    count += j-l
    QuickSort(A,j+1,r)
    count += r-(j+1)

text_file = open("quickSort.txt", "r")
Arr = text_file.read().split()
Arr = map(int,Arr)
# Arr = Arr[0:10]
n = len(Arr)

count = 0
QuickSort(Arr,0,len(Arr))

print count
