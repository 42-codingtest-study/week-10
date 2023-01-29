# 어려운 소인수분해
# https://www.acmicpc.net/problem/16563

N = int(input())
k = list(map(int, input().split()))
prime = [True] * (5000001)		# 소수 리스트
thdlstn = [i for i in range(5000001)]	# 소인수 리스트
prime[0] = prime[1] = False
for i in range(5000001) :
    if prime[i] :
        for j in range(2 * i, 5000001, i) :
            prime[j] = False	# i의 배수인 j는 소수가 아니므로 소인수가 존재한다
            if thdlstn[j] == j :	# 만약 지금까지 소인수가 없었다면
                thdlstn[j] = i		# 현재의 i가 가장 작은 소인수가 된다

def fn(n) :
    while (n > 1) :
        print(thdlstn[n], end = ' ')	# 여기서 멘붕했다..
        n //= thdlstn[n]	# n /= thdlstn[int(n)] 과 n //= thdlstn[n]의 차이로 시간초과가 났었음..
    if (n != 1) :
        print(int(n), end = ' ')

for kj in k :
    fn(kj)
    print()