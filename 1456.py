# 거의 소수
# https://www.acmicpc.net/problem/1456

# 테스트 케이스 다 맞는데 왜 3퍼센트에서 틀리는지 모르겠음 ...
A, B = map(int, input().split())
## 미리 소수 계산해놓기
prime = [True] * (int(B ** 0.5) + 1)
prime[0] = prime[1] = False
for i in range(int(B ** 0.5) + 1) :
    if prime[i] :
        for j in range(2 * i, int(B ** 0.5) + 1, i) :
            prime[j] = False
# print(prime)
answer = 0
for i in range(int(B ** 0.5) + 1) :
    n = 2
    while (prime[i] and i ** n <= B) :
        if (i ** n >= A) :
            answer += 1
        n += 1
print(answer)