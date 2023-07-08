/*

Given a number, swap the adjacent bits in the binary representation of the number, and print the new number formed after swapping.

Input Format

First line of input contains T - number of test cases. Each of the next T lines contains a number N.

Constraints

1 <= T <= 100000
0 <= N <= 109

Output Format

For each test case, print the new integer formed after swapping adjacent bits, separated by new line.

Sample Input

4
10
7
43
100

Sample Output

5
11
23
152

Explanation

Test Case 1

Binary Representation of 10: 000...1010
After swapping adjacent bits: 000...0101 (5)

Test Case 2

Binary Representation of 7: 000...0111
After swapping adjacent bits: 000...1011 (11)

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            long n = sc.nextLong();
            long res =  0;
            long x = 0;
            while(n != 0) {
                long prev = (n&1);
                n = n>>1;
                
                long next = (n&1);
                n=n>>1;
                if(next != 0) {
                    res+=(1<<(x));
                }
                if(prev != 0) {
                    res += (1<<(x+1));
                }
                    
                x+=2;
            }
            
            System.out.println(res);
        }
    }
}
