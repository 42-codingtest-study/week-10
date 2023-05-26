a, b = map(int, input().split())

# 소수리스트 생성
def get_prime_list(min_num, max_num):
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

    prime_num = [x for x in prime_list if x >= min_num]

    return prime_num

prime_num = get_prime_list(a, b)

if b > 10000000:
    b = 10000000

palindrome = [n for n in prime_num if str(n) == str(n)[::-1]]

for i in palindrome:
    print(i, end = '\n')
print(-1)

