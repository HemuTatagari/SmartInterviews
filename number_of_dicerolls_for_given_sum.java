/*

Given a standard 6-sided dice, find the number of ways to get a sum of N.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains N - the desired sum.

Constraints

1 <= T <= 100000
1 <= N <= 100000

Output Format

For each test case, print the number of ways to get a sum of N, separated by newline. Since the answer can be very large, print answer % 1e9+7.

Sample Input 0

5
3
11
7
5
500
Sample Output 0

4
976
63
16
765996555
Explanation 0

Test Case 1
You can get a sum of 3 in the ways:
(1,1,1), (1,2), (2,1), (3)

  */



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 1000000007;
        int[] dp = new int[100001];
        dp[0] = 1;
        
        for(int i=1;i<=100000;i++) {
            for(int j=1;j<7 && (i-j)>=0;j++) {
                dp[i] = (dp[i] + dp[i-j]) % k;
            }
        }
        int T = sc.nextInt();
        while(T-- > 0) {
            System.out.println(dp[sc.nextInt()] % k);
        }
    }
}
