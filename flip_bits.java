/*

You are given two numbers A and B. Write a program to count the number of bits to be flipped to change the number A to the number B. Flipping a bit of a number means changing a bit from 1 to 0 or vice versa.

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains 2 integer A and B, separated by space.

Constraints

1 <= T <= 100000
0 <= N <= 109

Output Format

For each test case, print the number of bit flips required to convert A to B, separated by new line.

Sample Input 0

4
20 10
16 8
1 153
549 24
Sample Output 0

4
2
3
6
Explanation 0

Self Explanatory

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            long from = sc.nextInt();
            long to = sc.nextInt();
            
            long temp = (from ^ to);
            
            System.out.println(countBits(temp));
        }
    }
    
    public static int countBits(long n){
        int res = 0;
        while(n != 0) {
            if((n&1L) == 1) { 
                res++;
                
            }
            n = n>>1;
        }
        return res;
    }
}
