n = int(input())
natural = list(input().split())

def factorization(num):
    n = 2
    num_list = []

    while num >= n:
        if num % n == 0:
            num_list.append(n)
            num = num / n
        else:
            n = n + 1

    for i in num_list:
        print(i, end=' ')

for i in natural:
    factorization(int(i))
    print()

