/*


Given 2 numbers, find their LCM and HCF.
Note: Do not use any inbuilt functions/libraries for your main logic.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains 2 numbers A and B.

Constraints

1 <= T <= 105
1 <= A,B <= 109

Output Format

For each test case, print their LCM and HCF separated by space, separated by newline.

Sample Input 0

4
4 710
13 1
6 4
605904 996510762
Sample Output 0

1420 2
13 1
12 2
7740895599216 78
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
            long a = sc.nextInt();
            long b = sc.nextInt();
            
            long t1 = a, t2 = b, t =0;
            while(t2 != 0) {
                t = t2;
                t2 = t1 % t2;
                t1 = t;
            }
            
            long gcd = t1;
            long lcm = (a * b)/t1;
            
            System.out.println(lcm + " " + gcd);
            T--;
        }
        
        
    }
}
