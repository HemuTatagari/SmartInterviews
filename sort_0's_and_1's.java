/*

You are given an array of 0's and 1's. Sort the array in ascending order and print it.
Note: Solve using two-pointer technique.

Input Format

First line of input contains T - the number of test cases. Its followed by 2T lines, the first line contains N - the size of the array.
The second line contains the elements of the array.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= A[i] <= 1

Output Format

For each test case, sort the array in ascending order and print it on a new line.

Sample Input 0

2
5
0 1 1 0 1
6
1 1 1 1 1 0
Sample Output 0

0 0 1 1 1
0 1 1 1 1 1
Explanation 0

Self explanatory

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
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            
            int i=0,j=n-1;
            while(i<j) {
                while(i<n && arr[i] != 1) {
                    i++;
                }
                while(j>=0 && arr[j] != 0 ) {
                    j--;
                }
                
                if(i<j) {
                    swap(i,j,arr);
                }
            }
            
            for(int k=0;k<n;k++) {
                System.out.print (arr[k] +" ");
            }
            System.out.println();
        }
    }
    
    public static void swap(int i,int j,int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
