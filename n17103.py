t = int(input())
num_list = []

for _ in range(t):
    n = int(input())
    num_list.append(n)

# 소수리스트 생성
def get_prime_list(max_num):
    prime_list = [2]
    next_num = 3

    while next_num < max_num:
        for i in prime_list:
            if i > next_num / i:
                prime_list.append(next_num)
                break
            if next_num % i == 0:
                break
        next_num += 1

    return prime_list

for i in num_list:
    prime_num = get_prime_list(i)
    print(prime_num)

    Gold = 0

    for j in prime_num:
        for k in prime_num:
            if j + k == i:
                Gold += 1

    print(Gold)
    # 흠 출력 왜이러징

