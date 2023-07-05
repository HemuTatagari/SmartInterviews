T = int(input())
while( T > 0):
    x,y = map(int, input().split())
    
    print((( 1 << (x+y)) - (1 << y)) % 1000000007)
    T = T-1
