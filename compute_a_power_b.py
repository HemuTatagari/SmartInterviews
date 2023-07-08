'''
Given 2 numbers - a and b, evaluate ab.
Note: Do not use any inbuilt functions/libraries for your main logic.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing 2 numbers - a and b, separated by space.

Constraints

30 points
1 <= T <= 1000
0 <= a <= 106
0 <= b <= 103

70 points
1 <= T <= 1000
0 <= a <= 106
0 <= b <= 109

Output Format

For each test case, print ab, separated by new line. Since the result can be very large, print result % 1000000007

Sample Input 0

4
5 2
1 10
2 30
10 10
Sample Output 0

25
1
73741817
999999937
Explanation 0

Self Explanatory

'''
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
