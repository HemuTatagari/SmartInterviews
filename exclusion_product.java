/*

You are given an array of integers of size N. Create a new array such that the element at an index i in the new array is the product of all the elements of the original array except the element present at index i.

Input Format

First line of input contains T - number of test cases. For each test case, the first line contains N - the size of the array. The second line contains N integers - the elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 105
0 <= A[i] <= 105

Output Format

For each test case, print the new array, separated by a newline. Since these numbers can be very large, print the numbers % 109 + 7

Sample Input 0

2
5
1 5 3 2 8
6
4 10 1 2 8 3
Sample Output 0

240 48 80 120 30
480 192 1920 960 240 640
Explanation 0

Test-Case 1
The product of all elements of the array except for the element at index 0 is 5 * 3 * 2 * 8 = 240
The product of all elements of the array except for the element at index 1 is 1 * 3 * 2 * 8 = 48
The product of all elements of the array except for the element at index 2 is 1 * 5 * 2 * 8 = 80
The product of all elements of the array except for the element at index 3 is 1 * 5 * 3 * 8 = 120
The product of all elements of the array except for the element at index 4 is 1 * 5 * 3 * 2 = 30

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        long k = 1000000007;
        
        while(T-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextLong();
            }
            
            long[] left = new long[n];
            long right[] = new long[n];
            
            left[0] = arr[0];
            for(int i=1;i<n;i++) {
                left[i] = (left[i-1]*arr[i])%k;
            }
            
            right[n-1]=arr[n-1];
            for(int i=n-2;i>=0;i--) {
                right[i] = (right[i+1]*arr[i])%k;
            }
            
            long ans[] = new long[n];
            if(n>0) {
                ans[0] = right[1];
            }
            ans[n-1] = left[n-2];
            
            for(int i=1;i<n-1;i++) {
                ans[i] = (left[i-1]*right[i+1])%k;
            }
            
            for(int i=0;i<n;i++) {
                System.out.print (ans[i]+" ");
            }
            
            System.out.println();
        }
    }
}
