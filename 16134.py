# 조합(Combination)
# https://www.acmicpc.net/problem/16134

N, K = map(int, input().split())
p = 10 ** 9 + 7
a = b = 1
for i in range(min(K, N - K)):
    a *= N - i; a %= p
    b *= i + 1; b %= p
invb = pow(b, p - 2, p)
ans = a * invb % p
print(ans)
print("what is this code?")
