# 다이어트
# https://www.acmicpc.net/problem/1484

G = int(input())
lst = [int(x ** 2) for x in range(100001)]	# 미리 제곱값들을 저장해둠

prev, curr = 1, 2	# 현재 값과 과거 값을 비교
answer = []
while True :
    if curr - prev == 1 and lst[curr] - lst[prev] > 100000 :	# 종료조건
        break

    if lst[curr] - lst[prev] < G:	# 두 값의 차가 G보다 작을때는 현재 인덱스를 올린다
        curr += 1
    elif lst[curr] - lst[prev] > G:	# 차가 크다면 과거 인덱스를 올린다
        prev += 1
    else:	# 같다면 정답에 포함시키고 과거를 올려 반복문을 수행한다.
        answer.append(curr)
        prev += 1

if answer:
    print(*answer, sep = '\n')
else:
    print(-1)
