# 거의 소수
# https://www.acmicpc.net/problem/1456

# 테스트 케이스 다 맞는데 왜 3퍼센트에서 틀리는지 모르겠음 ...
A, B = map(int, input().split())
## 미리 소수 계산해놓기
prime = [True] * (int(B ** 0.5) + 1)
prime[0] = prime[1] = False
for i in range(int(B ** 0.5) + 1) :
    if prime[i] :
        if i * i > int(B ** 0.5) :
            break
        for j in range(2 * i, int(B ** 0.5) + 1, i) :
            prime[j] = False

answer = 0
for i in range(int(B ** 0.5) + 1) :
    if prime[i] :
        res = i * i
        while True :
            if res < A :
                res *= i
                continue
            if res > B :
                break
            res *= i
            answer += 1
print(answer)