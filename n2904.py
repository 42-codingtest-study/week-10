N = int(input())

primes = []
visited=[False]*2+[True]*999
#1-1000까지의 소수 구하기

for x in range(2,1001):
    if visited[x]:
        primes.append(x)
        for y in range(2*x,1001,x):
            visited[y]=False
##가능한 인수 모두 구해두기

lis=list(map(int,input().split()))
nlist=[]
ma=dict()
for x1 in primes:
    ma[x1]=0
for x2 in range(N):
    k=lis[x2]
    a=[]
    for y1 in primes:
        if k==1:
            break
        while k%y1==0:
            k=k//y1
            a.append(y1)
            ma[y1]+=1
    if k!=1:
        a.append(k)
        ma[k]=1
        primes.append(k)
    nlist.append(a.copy())
mac=dict()
for x3 in primes:
    if ma[x3]//N!=0:
        mac[x3]=ma[x3]//N
cnt=0
for x4 in nlist:
    for y2 in mac:#mac 안에 소수
        if mac[y2]-x4.count(y2)>0:
            cnt+=mac[y2]-x4.count(y2)
result=1
for x5 in mac:
    y3=mac[x5]
    result*=x5**y3

print(result,cnt)