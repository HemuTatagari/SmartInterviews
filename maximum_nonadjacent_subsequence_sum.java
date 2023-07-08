/*

Given an array of integers, find the maximum subsequence sum, such that no 2 elements of the subsequence are adjacent to each other. Note that you cannot select an empty subsequence.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - size of the array and the second line contains N integers - elements of the array.

Constraints

1 <= T <= 1000
1 <= N <= 10000
-1000 <= ar[i] <= 1000

Output Format

For each test case, print the maximum subsequence sum, separated by newline.

Sample Input 0

4
8
-24 28 28 55 -31 -27 -45 -24 
11
40 5 39 45 31 -99 -44 73 -16 -31 27 
7
57 18 -14 17 31 16 -16 
2
26 61 
Sample Output 0

83
210
90
61
Explanation 0

Self Explanatory
  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            
            long[] dp = new long[n];
            dp[0] = arr[0];
            long maxx = Integer.MIN_VALUE; 
            for(int i=1;i<n;i++) {
                dp[i] = Math.max(arr[i],maxx + arr[i]);
                maxx = Math.max(maxx, dp[i-1]);
                //System.out.println(dp[i]+" "+maxx);
            }
            
            System.out.println(Math.max(maxx,dp[n-1]));
        }
    }
}
