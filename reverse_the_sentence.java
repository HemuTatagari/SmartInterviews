/*

Given a sentence, reverse the entire sentence word-by-word.
Note: Solve using stack or in-place swap. Do not simply scan, split and print in reverse order.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains a sentence S of space separated words of lowercase english alphabet. All the words are separated by a single space.

Constraints

1 <= T <= 1000
1 <= len(S) <= 1000

Output Format

For each test case, print the reversed sentence, separated by newline.

Sample Input 0

3
hello world
a b c d
data structures and algorithms
Sample Output 0

world hello
d c b a
algorithms and structures data
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
        sc.nextLine();
        while(T-- > 0) {
            String str = sc.nextLine();
            String[] stack = new String[str.length()];
            int top = -1;
            for(int i=0;i<str.length();i++) {
                char c = (str.charAt(i));
                if(top==-1) {
                    stack[++top] = String.valueOf(str.charAt(i));
                }
                else if(c == ' ') {
                    top++;
                }
                else {
                    if(stack[top] == null) {
                        stack[top] = String.valueOf(str.charAt(i));
                    }
                    else {
                        stack[top]=stack[top] + c;
                    }
                }
            }
            
            while(top!=-1) {
                System.out.print (stack[top--]+" ");
            }
            
            System.out.println();
        }
    }
}
