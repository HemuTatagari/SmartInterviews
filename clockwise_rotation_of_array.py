/*

Given an array, rotate it by K times in a clockwise direction.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and K - the degree of rotation. The second line contains the elements of the array.

Constraints

10 points
1 <= T <= 100
1 <= N <= 103
1 <= K <= 103
1 <= ar[i] <= 100

40 points
1 <= T <= 100
1 <= N <= 104
1 <= K <= 109
1 <= ar[i] <= 100

Output Format

For each test case, print the k-rotated array, separated by newline.

Sample Input 0

1
7 3
3 10 4 5 10 7 2 
Sample Output 0

10 7 2 3 10 4 5 
Explanation 0

Self Explanatory



  */

for _ in range(int(input())) :
    n,k= map(int,input().split())
    
    k = k%n
    
    l = list(map(int,input().split()))
    
    print(*(l[n-k:] + l[0:n-k]))
    
