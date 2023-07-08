/*

Given 2 matrices, find the product.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N1, M1 - size of the 1st matrix. Its followed by N1 lines each containing M1 intergers - elements of the 1st matrix. The next line contains N2, M2 - size of the 2nd matrix. Its followed by N2 lines each containing M2 intergers - elements of the 2nd matrix. Note that M1 = N2.

Constraints

1 <= T <= 100
1 <= N1,M1,N2,M2 <= 50
-100 <= mat[i][j] <= 100

Output Format

For each test case, print the resultant product matrix, separated by newline.

Sample Input 0

2
2 2
1 2 
3 -1 
2 3
1 -2 3 
2 3 -1 
2 3
27 29 53 
-28 49 -24 
3 4
23 52 -38 72 
-64 15 -59 -10 
-75 43 10 25 
Sample Output 0

5 4 1 
1 -9 10 
-5210 4118 -2207 2979 
-1980 -1753 -2067 -3106 
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T > 0) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            
            int mat1[][] = new int[r1][c1];
            for(int i=0; i<r1;i++) {
                for(int j=0; j<c1; j++) {
                    mat1[i][j] = sc.nextInt();
                }
            }
            
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            
            int mat2[][] = new int[r2][c2];
            for(int i=0; i<r2;i++) {
                for(int j=0; j<c2; j++) {
                    mat2[i][j] = sc.nextInt();
                }
            }
            
            int res[][] = new int[r1][c2];
            
            for(int i=0; i<r1; i++) {
                for(int j=0; j<c2; j++) {
                    
                    for(int k=0; k<r2; k++) {
                        res[i][j] += mat1[i][k] *mat2[k][j];
                    }
                }
            }
            
            printMat(res, r1, c2);
            T--;
            
        }
    }
    
    public static void printMat(int[][] res, int r, int c) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print (res[i][j] + " ");
            }
            
            System.out.println();
        }
    }
}
