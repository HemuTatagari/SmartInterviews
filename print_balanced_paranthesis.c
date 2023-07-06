/*

Write a program to generate all possible strings with balanced paranthesis having N pairs of curly braces.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains a single integer N.

Constraints

1 <= T <= 12
1 <= N <= 12

Output Format

For each test case, print each combinational pair of balanced paranthesis of length N in a lexicographical order along with the test case number, separated by newline.

Sample Input 0

2
3
2
Sample Output 0

Test Case #1:
{{{}}}
{{}{}}
{{}}{}
{}{{}}
{}{}{}
Test Case #2:
{{}}
{}{}
Explanation 0

Self Explanatory

*/


#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void printPar(char* arr, int n, int idx, int open, int close)
{
    if(idx == n)
    {
        for(int i=0;i<n;i++)
            printf("%c",arr[i]);
        printf("\n");
        return;
        
    }
    if(open<(n/2))
    {
        arr[idx] = '{';
        printPar(arr,n,idx+1,open+1,close);
    }
    if(close<open)
    {
        arr[idx] = '}';
        printPar(arr,n,idx+1,open,close+1);
    }
}

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int t;
    scanf("%d",&t);
    for(int p=0;p<t;p++)
    {
        printf("Test Case #%d:\n",p+1);
        int n;
        scanf("%d",&n);
        char arr[2*n];
        printPar(arr,2*n,0,0,0);
    }
    return 0;
}
