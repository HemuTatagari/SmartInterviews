/*

You have to complete N jobs using 2 machines. You can only work on 1 job at a time and the jobs should be completed in the order given in the input. The time to complete a particular job is different on Machine-1 and Machine-2. Also, there is a switching time of K involved between the machines. Find the minimum time required to complete all the jobs.

Input Format

First line of input contains T - number of test cases. First line of each testcase contains 2 integers N and K, it's followed by 2 lines, each containing N integers where ith number in each line denotes the time taken by the Machine-1 and Machine-2 to complete the ith job respectively.

Constraints

1 <= T <= 103
1 <= N, K <= 103
1 <= A[i], B[i] <= 105

Output Format

For each test case, print the minimum time to complete all the jobs, separated by new line.

Sample Input 0

2
5 8
11 34 50 29 17 
36 48 27 13 18 
5 2
18 23 44 37 36 
46 29 42 45 8 
Sample Output 0

111
132
Explanation 0

Test Case 1

Jobs will be executed in the following order: Machine-1, Machine-1, Machine-2, Machine-2, Machine-2.

Total Cost = 11 + 34 + 8 + 27 + 13 + 18 = 111.

Test Case 2

Jobs will be executed in the following order: Machine-1, Machine-1, Machine-1, Machine-1, Machine-2.

Total Cost = 18 + 23 + 44 + 37 + 2 + 8 = 132.

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int st = sc.nextInt();
            
            int a[] = new int[n];
            int b[] = new int[n];
            
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            
            for(int i=0;i<n;i++) {
                b[i] = sc.nextInt();
            }
            
            int prev_a = 0, prev_b = 0;
            for(int i=0;i<n;i++) {
                int curr_a = Math.min(prev_a , prev_b + st) + a[i];
                int curr_b = Math.min(prev_b , prev_a + st) + b[i];
                prev_a = curr_a;
                prev_b = curr_b;
            }
            
            System.out.println(Math.min(prev_a, prev_b));
        }
    }
}
