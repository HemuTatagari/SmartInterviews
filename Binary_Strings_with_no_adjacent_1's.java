/*

Find of number of binary strings of length N, such that there are no adjacent 1s in that string.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains N - length of the binary string.

Constraints

1 <= T <= 100000
1 <= N <= 100000

Output Format

For each test case, print the number of binary strings of length N, separated by newline. Since the answer can be very large, print answer % 1e9+7.

Sample Input 0

5
3
11
7
5
500
Sample Output 0

5
233
34
13
73724597
Explanation 0

Test Case 1
You can construct the following binary strings of length 3 with no adjacent 1s:
000, 001, 010, 100, 101

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 1000000007;
        int[] dp = new int[100001];
        int prev_0 = 1, prev_1 = 0;
        dp[0] = 1;
        for(int i=1;i<=100000;i++) {
                int curr_0 = (prev_0 + prev_1)%k;
                int curr_1 = (prev_0);
                dp[i] = (curr_0 + curr_1) %k;
                prev_0 = curr_0;
                prev_1 = curr_1;
            }
        
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }

    }
}
