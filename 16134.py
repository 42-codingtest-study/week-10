# 조합(Combination)
# https://www.acmicpc.net/problem/16134

N, K = map(int, input().split())
p = 10 ** 9 + 7
a = b = 1
for i in range(min(K, N - K)):	# 조합 계산
    a *= N - i; a %= p	# 팩토리얼 계산, 그런데 모듈로 연산을 곁들인
    b *= i + 1; b %= p	# 이것도 마찬가지
invb = pow(b, p - 2, p)	# b의 역원을 구해준다
ans = a * invb % p	# 모듈로 연산은 나눗셈 연산이 존재하지 않으므로, 역원을 구해 곱해주는 형식을 취한다.
print(ans)
