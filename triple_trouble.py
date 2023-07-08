'''
Given an array of size 3X+1, where every element occurs three times, except one element, which occurs only once. Find the element that occurs only once.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array (of the form 3X + 1) and second line contains the elements of the array.

Constraints

1 <= T <= 300
1 <= N <= 104
1 <= A[i] <= 109

Output Format

For each test case, print the number which occurs only once, separated by new line.

Sample Input 0

2
10
5 7 8 7 7 5 5 9 8 8 
7
10 20 20 30 20 10 10 
Sample Output 0

9
30
Explanation 0

Self Explanatory

'''
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
