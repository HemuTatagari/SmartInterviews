
# bit manipulation

T = int(input())
for _ in range(T) :
    base, power = map(int, input().split())
    res = 1
    x = base
    while(power != 0) :
        if((power & 1) == 1) :
            res = (res * x)%1000000007
        
        
        power =( power >> 1)
        x = (x*x) % 1000000007
    print(res)
