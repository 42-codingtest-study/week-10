# 문제이해가어려웠따,,,
import sys
input = sys.stdin.readline


g = int(input())
# end = 현재 몸무게 
# start = 기억된몸무게
start, end = 1, 2
flag = 0

while start < end:
    res = (end**2 - start**2)
    if res >= g:
        start+=1
        if res == g:
            print(end)
            flag = 1
    else:
        end += 1
    if flag == 0:
        print(-1)