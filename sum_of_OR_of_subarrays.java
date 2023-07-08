/*

You are given an array of size N. Find the sum of the results of bitwise OR of all the subarrays.

Input Format

First line of input contains T - the number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

10 points
1 <= T <= 100
1 <= N <= 100
0 <= A[i] <= 105

20 points
1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 105

70 points
1 <= T <= 1000
1 <= N <= 104
0 <= A[i] <= 105

Output Format

For each test case, print the result separated by a newline.

Sample Input 0

2
4
3 2 0 1 
6
1 9 8 1 12 0 
Sample Output 0

21
201
Explanation 0

Test Case 1:
The sum of bitwise OR of all subarrays is 3 + 2 + 0 + 1 + 3|2 + 2|0 + 0|1 + 3|2|0 + 2|0|1 + 3|2|0|1 = 21

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextLong(); 
            }
            long k = 1000000007;
            long sum=0;
            for(int i=0;i<=30;i++) {
                long ref_ind = n;
                for(int j=n-1;j>=0;j--) {
                    if(((arr[j]>>i)&1) == 1) {
                        ref_ind = j;
                    }
                    sum+= (n-ref_ind+k)%k*(1<<i);
                }
            }
            
            System.out.println(sum);
            
            
        }
        
    }
}
