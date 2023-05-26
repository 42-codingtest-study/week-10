g = int(input())

def cal(a, b):
    return a ** 2 - b ** 2

a = 1
b = 1

no_answer = True

while True:
    if cal(a, b) == g:
        no_answer = False

        print(a)
        a += 1
    elif cal(a, b) > g:
        b += 1
    elif cal(a, b) < g:
        a += 1

if no_answer:
    print(-1)
