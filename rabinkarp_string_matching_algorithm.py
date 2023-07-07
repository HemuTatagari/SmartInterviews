/*

Given an 2 strings A and B, find the number of occurrences of A in B as a substring. Solve using Rabin-Karp string matching algorithm with multiple hash functions. Do not use inbuilt library.

Input Format

First line of input contains T - number of test cases. Its followed by T lines. Each line contains 2 strings - A and B, separated by space.

Constraints

1 <= T <= 2000
1 <= len(A), len(B) <= 10005
'a' <= A[i], B[i] <= 'z'

Output Format

For each test case, print the number of occurrences of A in B, separated by newline.

Sample Input 0

4
smart yekicmsmartplrplsmartrplplmrpsmartrpsmartwmrmsmartsmart
interviews interviewseiwcombvinterviewskrenlzp
ds dsdsajdsrjjdsjjj
algo yalgoalgoalgopalgoaxalgoasaxalgolalgoalgoalgo
Sample Output 0

6
2
4
9
Explanation 0

Self Explanatory

*/

// hashing
for z in range(int(input())) :
    s1,s2 = map(str,input().split())
    n = len(s1)
    m = len(s2)
    k = 1000000007
    
    pri = 31
    l_p = pri
    ha = ((ord(s1[0])-97)*l_p)%k
    hb= ((ord(s2[0])-97)*l_p)%k
    
    l_p = (l_p * pri)%k
    for i in range(1,n) :
        ha =( ha+((ord(s1[i])-97)*l_p)%k)%k
        hb = (hb+((ord(s2[i])-97)*l_p)%k)%k
        l_p = (l_p * pri)%k
    count = 0;
    if(ha == hb) :
        count+=1
    t_p = pri;
    for i in range(n,m) :
        hb = (hb-((((ord(s2[i-n])-97)*t_p)+k)%k)+ (((ord(s2[i])-97)*l_p)%k))%k
        ha = (ha*pri)%k
        t_p = (t_p * pri)%k
        l_p = (l_p * pri)%k
        if(ha == hb) :
            count+=1
    print(count)
        
