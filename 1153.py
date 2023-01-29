# 네 개의 소수
# https://www.acmicpc.net/problem/1153

N = int(input())
prime = [1] * (N + 1)
prime[0] = prime[1] = 0
prime_lst = []
for i in range(2, N + 1) :
    if prime[i] :
        prime_lst.append(i)
        for j in range(i * i, N + 1, i):
            prime[j] = 0

def goldbach(n) :
    for i in range(len(prime_lst)) :
        for j in range(len(prime_lst)) :
            n_sum = prime_lst[i] + prime_lst[j]
            if n_sum == n :
                ans.extend([prime_lst[i], prime_lst[j]])
                return
            elif n_sum > n :
                break


if N < 8 :
    print(-1)
else:
    if N % 2 == 0 :
        ans = [2, 2]
        N -= 4
        goldbach(N)
        print(*ans)
    else :
        ans = [2, 3]
        N -= 5
        goldbach(N)
        print(*ans)