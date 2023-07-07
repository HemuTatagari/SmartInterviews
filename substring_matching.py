/*

You are given two strings A and B. You are also given Q queries with 4 indices i, j, k and l. Check whether the substring of A[i:j] matches the substring of B[k:l].

Input Format

First line of input contains T - number of test cases. In each test case, the first line contains the string A and the second line contains the string B.
The next line contains an integer Q - the number of queries. The Q subsequent lines each contain 4 integers i, j, k and l, separated by a space.

Constraints

30 points
1 <= T <= 100
1 <= len(A), len(B) <= 100
0 <= Q <= 1000

70 points
1 <= T <= 100
1 <= len(A), len(B) <= 10000
0 <= Q <= 10000

General Constraints
'a' <= A[i], B[i] <= 'z'
0 <= i <= j < len(A)
0 <= k <= l < len(B)

Output Format

For each query, on a new line, print "Yes" if the substring of A matches the substring of B, print "No" otherwise.

Sample Input 0

2
smartinterviews
intermediate
2
5 9 0 4
1 3 2 4
hackerrank
hackerearth
1
0 3 0 3
Sample Output 0

Yes
No
Yes
Explanation 0

Test Case 1
The substring of "smartinterviews" from index 5 to 9 is "inter". The substring of "intermediate" from 0 to 4 is also "inter". Since they are equal, the output is "Yes".
The substring of "smartinterviews" from index 1 to 3 is "mar". The substring of "intermediate" from 2 to 4 is "ter". Since they are not equal, the output is "No".

  */

// note :- good hasing technique
for z in range(int(input())) :

    s1 = input()
    s2 = input()

    n = len(s1)
    m = len(s2)

    pri = 31
    k = 1000000007
    pha = [0]*n
    phb = [0]*m

    pow = [0]*max(m,n)
    
    pha[0] = (ord(s1[0])*pri)%k
    phb[0] = (ord(s2[0])*pri)%k

    pow[0] = pri
    for i in range(1,max(m,n)) :
        pow[i] = (pow[i-1]*pri)%k
        
    for i in range(1,n) :
        pha[i] = (pha[i-1] + (ord(s1[i])*pow[i])%k)%k

    for i in range(1,m) :
        phb[i] = (phb[i-1] + (ord(s2[i])*pow[i])%k)%k

    Q = int(input())

    for i in range(Q) :
        p,q,x,y = map(int,input().split())
        if(p==0) :
            h1 = pha[q]
        else :
            h1 = ((pha[q]-pha[p-1])+k)%k
    
        if(x==0) :
            h2 = phb[y]
        else :
            h2 = ((phb[y]-phb[x-1])+k)%k
    
        d = x-p
    
        if(d>0) :
            if((h1*pow[d-1])%k == h2) :
                print("Yes")
            else :
                print("No")
        elif(d < 0) :
            if(h1 == (h2*pow[(d*-1)-1])%k) :
                print("Yes")
            else :
                print("No")
        else :
            if(h1 == h2) :
                print("Yes")
            else:
                print("No")
            
            
