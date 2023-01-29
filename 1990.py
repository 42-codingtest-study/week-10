# import sys
# input = sys.stdin.readline

a, b = map(int, input().split())
if b > 10000000:
    b = 10000000 
primes = [True] * (10000001)
primes[0] = False
primes[1] = False

for i in range(10000001):
    if primes[i]:
        for j in range(i ** 2, 10000001, i):
            primes[j] = False

def isPalindrome(n):
    num = str(n)
    # print(len(num))
    for i in range(len(num) // 2):
        if num[i] != num[len(num) -1 -i]:
            # palindrome = n
            return(False)
    return(True)
    
# print(isPalindrome(12341))
# print(isPalindrome(222))

for i in range(a, b + 1) :
    if primes[i] and isPalindrome(i):
        print(i)
print(-1)