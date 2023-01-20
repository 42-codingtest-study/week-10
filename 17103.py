# 골드바흐 파티션
# https://www.acmicpc.net/problem/17103


## 시간초과(계산을 테스트마다 계속 해서 그렇다..)
# def is_prime(n) :
#     if n < 2 :
#         return False
#     if n == 2 :
#         return True
#     i = 2
#     while i < (n ** 0.5) + 1 :
#         if n % i == 0 :
#             return False
#         i += 1
#     return True

# for _ in range(int(input())) :
#     gold = int(input())
#     answer = 0
#     i = 2
#     while i <= gold / 2 :
#         if is_prime(i) and is_prime(gold - i) :
#             answer += 1
#         i += 1
#     print(answer)

## 미리 소수 계산해놓기
prime = [True] * 1000001
prime[0] = prime[1] = False
for i in range(1000001) :
    if prime[i] :	# i가 소수인 경우
        for j in range(2 * i, 1000001, i) :		# i의 배수들은 소수가 아니다
            prime[j] = False	# 그러므로 1000001까지 반복하면서 배수들을 제외시킨다.

for _ in range(int(input())) :
    gold = int(input())
    answer = 0
    for i in range(2, (gold // 2) + 1) :
        if prime[i] and prime[gold - i] :	# i가 소수이고, gold - i도 소수라면 정답임
            answer += 1
    print(answer)