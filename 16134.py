import sys
import itertools
input = sys.stdin.readline

# n, r = map(int,input().split())
# mul = 1
# res = 0
# for i in range(r):
#     mul *= n
#     n -= 1
# tmp = 1
# for i in range(r):
#     tmp *= r
# res = mul // tmp
# print(res)


def divide(num, div, SIZE):
	return num * pow(div, SIZE - 2, SIZE) % SIZE


def product(start, end, SIZE):
	value = 1
	for i in range(start, end + 1):
		value = value * i % SIZE
	
	return value


SIZE = 10 ** 9 + 7
n, k = map(int, input().split())
print(divide(
    product(k + 1, n, SIZE),
    product(2, n - k, SIZE),
    SIZE
))


