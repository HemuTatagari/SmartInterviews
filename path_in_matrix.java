/*

Given a matrix, find the number of ways to reach from the top-left cell to the right-bottom cell. At any step, from the current cell (i,j) you can either move to (i+1,j) or (i,j+1) or (i+1, j+1). Please note that certain cells are forbidden and cannot be used.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N, M - size of the matrix and B - number of forbidden cells. Its followed by B lines each containing a pair (i,j) - index of the forbidden cell.

Constraints

20 points
1 <= N, M <= 10

80 points
1 <= N, M <= 100

General Constraints
1 <= T <= 500
0 <= i < N
0 <= j < M

Output Format

For each test case, print the number of ways, separated by newline. Since the output can be very large, print output % 1000000007

Sample Input 0

5
5 2 1
2 0
7 3 1
1 0
6 3 1
5 2
2 9 1
0 1
5 6 2
0 1
1 0
Sample Output 0

4
24
0
2
129
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int b = sc.nextInt();
            long[][] dp = new long[n][m];
            
            for(int i=0;i<b;i++) {
                dp[sc.nextInt()][sc.nextInt()] = -1;
            }
            
            for(int i=0;i<m;i++) {
                if(dp[0][i] == -1) {
                    break;
                }
                else { 
                    dp[0][i] = 1;
                }
            }
            
            
            
             for(int i=0;i<n;i++) {
                if(dp[i][0] == -1) {
                    break;
                }
                else { 
                    dp[i][0] = 1;
                }
            }
            
            
            
            for(int i=1;i<n;i++) {
                for(int j=1;j<m;j++) {
                    if(dp[i][j] != -1) {
                        if( dp[i-1][j]!=-1) {
                        dp[i][j]+= dp[i-1][j];
                        }
                        if(dp[i][j-1]!=-1) {
                            dp[i][j]=(dp[i][j]+dp[i][j-1])% 1000000007;
                        }
                        if(dp[i-1][j-1]!=-1) {
                            dp[i][j]=(dp[i][j]+dp[i-1][j-1]) % 1000000007;
                        }
                    }
                    else {
                        dp[i][j] = 0;
                    }
                }
            }
            if(dp[n-1][m-1]==-1) {
                System.out.println(0);
            }
            else {
               System.out.println(dp[n-1][m-1] % 1000000007);
            }
            
        }
    }
}
