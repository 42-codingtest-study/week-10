#골드바흐의 추측 (2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.)
import sys
input = sys.stdin.readline

ls = [True] * 1000001
ls[0], ls[1] = False, False
primeList = []

for i in range(2, 100001):
    if ls[i]:
        primeList.append(i)
        # print(primeList)     
        if i < 1001:
            for j in range(i+i, 1000000, i):
                ls[j] = False


t = int(input())

for _ in range(t):
    n = int(input())
    cnt = 0
    for i in primeList:
        a = n - i
        if(i > a):
            break
        else:
            if ls[a]:
                cnt += 1
    print(cnt)


    