n = int(input())

# 소수리스트 생성
def get_prime_list(max_num):
    prime_list = [2]
    next_num = 3

    while next_num <= max_num:
        for i in prime_list:
            if i > next_num / i:
                prime_list.append(next_num)
                break
            if next_num % i == 0:
                break
        next_num += 1

    return prime_list

prime_num = get_prime_list(n)
answer = []

if n < 8:
    print(-1)
if n >= 8 and n % 2 == 0:
    answer.append(2)
    answer.append(2)
    n -= 4
else:
    answer.append(2)
    answer.append(3)
    n -= 5

# 흑흑
for i in range(2, n + 1):
    if prime_num[i] and prime_num[n - i]:
        answer.append(i)
        answer.append(n - i)

        for j in answer:
            print(j, end=' ')