/*

Print mirror image of right-angled triangle using '*'. See examples for more details.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single integer N - the size of the pattern.

Constraints

1 <= T <= 100
1 <= N <= 100

Output Format

For each test case, print the test case number as shown, followed by the pattern, separated by newline.

Sample Input 0

4
2
1
5
10
Sample Output 0

Case #1:
 *
**
Case #2:
*
Case #3:
    *
   **
  ***
 ****
*****
Case #4:
         *
        **
       ***
      ****
     *****
    ******
   *******
  ********
 *********
**********
Explanation 0

Self Explanatory

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int case1 = 1;
        int T = sc.nextInt();
        for(int i=0; i< T; i++,case1++) {
            int n = sc.nextInt();
            System.out.println("Case #" + case1 +":");
            for(int j=1; j<=n ;j++) {
                
                for(int k=0; k<(n-j);k++) {
                    System.out.print (" "+"");
                }
                for(int k=0; k<j;k++) {
                    System.out.print ("*" + "");
                }
                System.out.println();
            }
            
        }
    }
}
