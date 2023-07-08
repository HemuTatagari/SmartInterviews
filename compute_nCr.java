/*

Given n and r, compute nCr.
Do not use BigInteger class, it defeats the purpose of the problem statement.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains 2 integers - N and R.

Constraints

20 points
1 <= T <= 100
0 <= N, R <= 30

80 points
1 <= T <= 500000
0 <= N, R <= 2000

Output Format

For each test case, print the value of nCr, separated by newline. Since the number can be very large, print result % 1000000007.

Sample Input 0

5
4 2
3 1
25 12
30 14
6 4
Sample Output 0

6
3
5200300
145422675
15
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int n = 2001;
        int r = 2001;
        int[][] dp = new int[n][r];
        
        for(int i=0;i<n;i++) {
            dp[i][0] =  1;
        }
        
        for(int i=1;i<n;i++) {
            for(int j=1;j<r;j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j] )% 1000000007;
            }
        }
        
        while(T-- > 0) {
            System.out.println(dp[sc.nextInt()][sc.nextInt()] % 1000000007);
        }
        
    }
}
