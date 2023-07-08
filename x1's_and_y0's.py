'''
Given two numbers X and Y, find the number whose binary representation has X 1's followed by Y 0's.

Input Format

First line of input contains T - number of test cases. Its followed by T lines. Each subsequent line contains two integers separated by a space: X - the number of the 1's and Y - the number of 0's which follows the X 1's in the binary representation of the number.

Constraints

10 points
1 <= T <= 100
0 <= X, Y <= 15

40 points
1 <= T <= 105
0 <= X, Y <= 105

Output Format

For each test case, print the number whose binary representation has X 1's and Y 0's, separated by a new line.
Since this number can be very large, print the result % 1000000007.

Sample Input 0

3
4 3
2 5
10 15
Sample Output 0

120
96
33521664
Explanation 0

Test Case 1
The binary representation of the number that has 4 ones followed by 3 zeros is 1111000 = 120.

'''

T = int(input())
while( T > 0):
    x,y = map(int, input().split())
    
    print((( 1 << (x+y)) - (1 << y)) % 1000000007)
    T = T-1
