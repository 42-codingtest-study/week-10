
# 팩토리얼 함수 사용
import math
import sys

input = sys.stdin.readline

n, r = map(int, input().split())

a = math.factorial(n)
b = math.factorial(r)
c = math.factorial(n - r)

result = a // (b * c)
print(result % 1000000007)

'''
# 단순 계산
import sys

input = sys.stdin.readline

n, r = map(int, input().split())

ans_n = 1
ans_r = 1

if r > (n - r):
    r = n - r

for _ in range(r):
    ans_n *= n
    n -= 1

for _ in range(r):
    ans_r *= r
    r -= 1

result = ans_n // ans_r
print(result % 1000000007)
'''