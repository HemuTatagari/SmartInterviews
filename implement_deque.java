/*


Perform push and pop operations on a deque. Implement Deque and avoid using inbuilt library.

Input Format

First line of input contains T - number of operations. Its followed by T lines, each line contains either "push_front x" or "push_back x" or "pop_front" or "pop_back".

Constraints

1 <= T <= 10000
-100 <= x <= 100

Output Format

For each of "pop_front" and "pop_back" operations, print the popped element, separated by newline. If the deque is empty, print "Empty".

Sample Input 0

10
push_back 5
pop_front
pop_front
push_back 10
push_front -15
pop_back
push_back -10
push_back 20
pop_front
pop_front
Sample Output 0

5
Empty
10
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
        int[] queue = new int[n];
        int front = -1, rear = -1;
        while(n-- > 0) {
            String str = sc.next();
            if(str.equals("push_back")) {
                int x = sc.nextInt();
                queue[++rear] = x;
                if(front == -1) {
                    front = 0;
                }
            }
            else if(str.equals("push_front")) {
                int x = sc.nextInt();
                if(front == -1 && rear == -1) {
                    rear++;
                    queue[++front] = x;
                }
                else if(front == 0) {
                    int temp = rear;
                    while(rear>=0) {
                        queue[rear+1] = queue[rear];
                        rear--;
                    }
                    rear = temp+1;
                    queue[front] = x;
                }
                else {
                    queue[--front] = x;
                }
            }
            
            else if(str.equals("pop_back")) {
                if(front == rear+1 || rear==-1) {
                    System.out.println("Empty");
                }
                else{
                    System.out.println(queue[rear--]);
                }
            }
            else {
                if(front == rear+1 || rear==-1) {
                    System.out.println("Empty");
                }
                else{
                    System.out.println(queue[front++]);
                }
            }
        }
    }
}
