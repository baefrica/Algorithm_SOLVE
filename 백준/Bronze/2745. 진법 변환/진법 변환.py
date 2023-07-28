N, B = input().split()
B = int(B)
n = len(N)
result = 0

for i in range(len(N)):
    if ord(N[i])>64:
        result += (ord(N[i])-ord('A')+10)*(B**(n-1))
    else:
        result += int(N[i])*(B**(n-1))
    n -= 1

print(result)
# ZZZZZ 36
