
n = int(input())
k = list(map(int, input().split()))
max_num = max(k)
arr = []

for i in range(max_num + 1):
    arr.append(i)
# print(arr)

for i in range(2, max_num + 1):
    if arr[i] == i:
        for j in range(i*i, max_num+1, i):
            arr[j] = i
# print(arr)
            
for i in k:
    if arr[i] == i:
        print(i)
        continue
    else:
        arr_2 = []
        while i != 1:
            arr_2.append(arr[i])
            i = int(i / arr[i])
        for j in sorted(arr_2):
            print(j, end=' ')
        print()
    