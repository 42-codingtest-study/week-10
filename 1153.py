primes = (2, 3)

def isprime(n):
    if n == 1:
        return False
    d = n - 1
    s = 0
    while d % 2 == 0:
        d //= 2
        s += 1
    for a in primes:
        if a >= n:
            break
        P = False
        if pow(a, d, n) == 1:
            P = True
            continue
        for r in range(s):
            if pow(a, pow(2, r) * d, n) == n - 1:
                P = True
                break
        if P == False:
            return False
    return True

N = int(input())
if N < 8:
    print(-1)
elif N & 1:
    print(2, 3, end= " ")
    N -= 5
else:
    print(2, 2, end= " ")
    N -= 4

k = 2
while k <= N:
    if isprime(k) and isprime(N - k):
        print(k, N - k)
        break
    k += 1