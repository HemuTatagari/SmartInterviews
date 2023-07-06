
t = int(input())
for _ in range(t) :
    n = int(input())
    l = list(map(int,input().split()))
    l.sort()
    
    i = 0
    flag = 1
    while(i<n-1) :
        if(l[i] != l[i+1]) :
            print(l[i])
            flag = 0
            break
        i+=3
    if(flag) :
        print(l[n-1])
