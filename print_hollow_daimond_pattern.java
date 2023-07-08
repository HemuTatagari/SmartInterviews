/*

Print hollow diamond pattern using '*'. See examples for more details.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single odd integer N - the size of the diamond.

Constraints

1 <= T <= 100
3 <= N <= 201

Output Format

For each test case, print the test case number as shown, followed by the diamond pattern, separated by newline.

Sample Input 0

4
3
7
5
15
Sample Output 0

Case #1:
 *
* *
 *
Case #2:
   *
  * *
 *   *
*     *
 *   *
  * *
   *
Case #3:
  *
 * *
*   *
 * *
  *
Case #4:
       *
      * *
     *   *
    *     *
   *       *
  *         *
 *           *
*             *
 *           *
  *         *
   *       *
    *     *
     *   *
      * *
       *
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
        int cases = 1;
        int T = sc.nextInt();
        while(T > 0) {
            int n = sc.nextInt();
            System.out.println("Case #" + cases + ":");
            
            int k = n/2;
            
            // first line
            //System.out.print (" "* k);
            for(int j=0; j<k;j++) {
                System.out.print(" "+"");
            }
            System.out.print ("*" + "\n");
            
            //next half lines
            for(int i=1; i<=n/2; i++) {
                //System.out.print(" " * k-1 );
                for(int j=0; j<k-i;j++) {
                    System.out.print(" "+"");
                }
                System.out.print("*"+"");
                
                for(int j=0; j<(2*(i)-1);j++) {
                    System.out.print(" "+"");
                }
                
                System.out.print ("*" + "\n");
            }
            
            //next half lines
            for(int i=1; i<n/2; i++) {
                //System.out.print(" " * i );
                for(int j=0; j<i;j++) {
                    System.out.print(" "+"");
                }
                
                System.out.print ("*" + "");
                for(int j=0; j<(n-2*(i+1));j++) {
                    System.out.print(" "+"");
                }
                
                System.out.print ("*" + "\n");
            }
            
            //last line
            //System.out.print (" "* k);
            for(int j=0; j<k;j++) {
                System.out.print(" "+"");
            }
            System.out.print ("*" + "\n");
            
            cases++;
            T--;
            
        }
    }
}
