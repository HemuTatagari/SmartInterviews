/*

Given a 2D matrix of size NxN, print the sum of the elements of all its diagonals.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - size of the matrix. Each of the next N lines contains N integers - the elements of the matrix.

Constraints

1 <= T <= 100
1 <= N <= 100
-100 <= ar[i][j] <= 100

Output Format

For each test case, print the sum of the elements of all the diagonals, separated by newline. Refer samples for more clarity.

Sample Input 0

4
3
-5 0 4 
2 8 -6 
3 7 1 
1
-4 
2
5 -2 
-4 1 
6
-2 -3 -6 -5 50 3 
8 7 10 -5 -3 30 
6 3 70 9 -20 -7 
-9 9 -6 7 3 2 
-1 7 7 6 -4 3 
8 5 6 -9 40 8 
Sample Output 0

4 -6 4 9 3 
-4 
-2 6 -4 
3 80 -15 -29 22 86 51 13 4 4 8 
Explanation 0

Test Case 1
Sum of the elements of the 1st diagonal: 4
Sum of the elements of the 2nd diagonal: 0 + -6 = -6
Sum of the elements of the 3rd diagonal: -5 + 8 + 1 = 4
Sum of the elements of the 4th diagonal: 2 + 7 = 9
Sum of the elements of the 5th diagonal: 3

Test Case 2
Sum of the elements of the 1st and only diagonal: -4

Test Case 3
Sum of the elements of the 1st diagonal: -2
Sum of the elements of the 2nd diagonal: 5 + 1 = 6
Sum of the elements of the 3rd diagonal: -4

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
        //input
        int T = sc.nextInt();
        
        while(T > 0) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            
            for(int i=0; i<n;i++) {
                for(int j=0; j<n;j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            
            //code
            int i=0, j=n-1;
            int sum = 0,p,q;
            while(i>=0 && j>=0) {
                p=i;
                q = j;
                sum = 0;
                while(p<n && q<n) {
                    sum+=mat[p][q];
                    p++;
                    q++;
                    
                }
                
                System.out.print(sum + " ");
                
                
                j--;
                i=0;
            }
            
            i=1;
            j=0;
            sum=0;
            while(i < n) {
                sum = 0;
                p=i;
                q=j;
                while(p<n && q<n) {
                    sum = sum + mat[p][q];
                    p++;
                    q++;
                }
                
                System.out.print (sum + " ");
                i+=1;
                j=0;
            }
            System.out.println();
            T--;
        }
        
    }
}
