/*

Given a 2D matrix of size NxM, find the maximum sub-matrix sum.

Input Format

First line of input contains T - number of test cases. First line of each test case contains 2 integers - N and M - the size of the matrix. Its followed by N lines each containing M integers.

Constraints

10 points
1 <= T <= 1000
1 <= N, M <= 10

30 points
1 <= T <= 1000
1 <= N, M <= 20

60 points
1 <= T <= 1000
1 <= N, M <= 50

100 points
1 <= T <= 1000
1 <= N, M <= 100

General Constraints
-100 <= Mat[i][j] <= 100

Output Format

For each test case, print the maximum sum possible, separated by newline.

Sample Input 0

3
4 4
-10 -20 -30 -40 
-10 20 -5 -10 
-10 -5 20 -10 
-10 -20 -30 -40 
2 6
24 -43 3 28 -48 61 
-53 37 -41 -25 12 -59 
5 3
13 -4 0 
-20 -8 20 
4 6 -26 
32 8 29 
-43 -29 -53 
Sample Output 0

30
61
69
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
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int[][] matrix = new int[n][m];
            
            //input
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            // prefix sum calculation
            int[][] col_ps = new int[n][m];
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++){
                    if(i==0) {
                        col_ps[i][j] = matrix[i][j];
                    }
                    else {
                        col_ps[i][j] = col_ps[i-1][j]+matrix[i][j];
                    }
                }
            }
            
            // forming diff combinations of rows
            long maxx = Integer.MIN_VALUE;
            for(int i=0;i<n;i++) {
                for(int k=i;k<n;k++) {
                    
                    //kadenes algo for each combination
                    long sum = 0;
                    for(int j=0;j<m;j++) {
                        sum+=col_ps[k][j];
                        if(i>0) {
                            sum-=col_ps[i-1][j];
                        }
                        
                        maxx = Math.max(maxx, sum);
                       // System.out.println(j+" "+sum+" "+maxx);
                        if(sum < 0){
                            sum = 0;
                        }
                    }
                    
                }
            }
            System.out.println(maxx);
            
        }
    }
}
