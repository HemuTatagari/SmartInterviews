/*

You are given an array of integers. Find the XOR of sum of all pairs formed by the elements of the array.

Input Format

First line of input contains T - the number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

10 points
1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 105

40 points
1 <= T <= 100
1 <= N <= 105
0 <= A[i] <= 105

Output Format

For each test case, print the XOR of sum of all pairs formed by the elements of the array, separated by a newline.

Sample Input 0

2
5
4 10 54 11 8 
6
15 35 25 10 15 12 
Sample Output 0

118
120
Explanation 0

Test Case 1
All the pairwise sums formed with 4 are (4 + 4), (4 + 10), (4 + 54), (4 + 11), (4 + 8) = 8, 14, 58, 15, 12
All the pairwise sums formed with 10 are (10 + 4), (10 + 10), (10 + 54), (10 + 11), (10 + 8) = 14, 20, 64, 21, 18
All the pairwise sums formed with 54 are (54 + 4), (54 + 10), (54 + 54), (54 + 11), (54 + 8) = 58, 64, 108, 65, 62
All the pairwise sums formed with 11 are (11 + 4), (11 + 10), (11 + 54), (11 + 11), (11 + 8) = 15, 21, 65, 22, 19
All the pairwise sums formed with 8 are (8 + 4), (8 + 10), (8 + 54), (8 + 11), (8 + 8) = 12, 18, 62, 19, 16

XOR of all the above sums = (8 ^ 14 ^ 58 ^ 15 ^ 12) ^ (14 ^ 20 ^ 64 ^ 21 ^ 18) ^ (58 ^ 64 ^ 108 ^ 65 ^ 62) ^ (15 ^ 21 ^ 65 ^ 22 ^ 19) ^ (12 ^ 18 ^ 62 ^ 19 ^ 16) = 118
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n;i++) {
                arr[i] = sc.nextInt();
            }
            int res = 0;
            
            for(int i=0;i<n;i++) {
                res = res ^ (arr[i] + arr[i]);
            }
            
            System.out.println(res);
            
        }
    }
}
