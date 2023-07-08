/*

Given a matrix of size MxN with 0's and 1's, find the area of maximum sized square submatrix with all 1's.

Input Format

First line of input contains T - number of test cases. First line of each testcase contains 2 integers M and N and it's followed by M lines each containing N numbers.

Constraints

1 <= T <= 50
1 <= M, N <= 1000

Output Format

For each test case, print the area of maximum sized square submatrix with all 1's, separated by new line.

Sample Input 0

1
4 4
0110
1111
1111
1100
Sample Output 0

4
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int[][] matrix = new int[m][n];
            for(int i=0;i<m;i++) {
                String num = sc.next();
                for(int j=0;j<n;j++){
                    matrix[i][j] = Character.getNumericValue(num.charAt(j));
                }
            }
            int[][] dp = new int[m+1][n+1];
            
            int maxx = 0;
            for(int i=1;i<=m;i++) {
                for(int j=1;j<=n;j++) {
                   if(matrix[i-1][j-1] == 1) {
                      dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                       maxx = Math.max(maxx, dp[i][j]);
                   } 
                }
            }
            
            System.out.println(maxx * maxx);
        }
    }
}
