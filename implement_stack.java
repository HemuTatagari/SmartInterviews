/*

Perform push and pop operations on stack. Implement Stacks and avoid using inbuilt library.

Input Format

First line of input contains T - number of operations. Its followed by T lines, each line contains either "push x" or "pop".

Constraints

1 <= T <= 10000
-100 <= x <= 100

Output Format

For each "pop" operation, print the popped element, separated by newline. If the stack is empty, print "Empty".

Sample Input 0

8
push 5
pop
pop
push 10
push -15
pop
push -10
pop
Sample Output 0

5
Empty
-15
-10
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int top = -1;
        while(n-- > 0) {
            String op = sc.next();
            if(op.equals("push")) {
                arr[++top] = sc.nextInt();
            }
            else {
                if(top==-1) {
                    System.out.println("Empty");
                }
                else {
                    System.out.println(arr[top--]);
                }
            }
        }
    }
}
