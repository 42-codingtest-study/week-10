
# 에라토스테네스의 체

a, b = map(int, input().split())

primeList = [True] * (int(b ** 0.5) + 1)
primeList[1] = False

for i in range(2, int(b ** 0.5) + 1):
    if primeList[i]:
        if i * i > int(b ** 0.5):
            # i 제곱이 b의 제곱근보다 큰지 확인
            break
        for j in range(i ** 2, int(b ** 0.5) + 1, i):
            primeList[j] = False

count = 0

for i in range(1, len(primeList)):
    if primeList[i]:
        res = i * i

        while True:
            if res < a:
                res *= i
                continue
            if res > b:
                break
            res *= i
            count += 1

print(count)