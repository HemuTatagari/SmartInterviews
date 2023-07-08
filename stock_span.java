/*

You are given a series of daily price quotes for a stock and you need to calculate span of stock’s price for each day. The span Si of the stock’s price on current day i is defined as the maximum number of consecutive days just before the current day[including the current day], on which the price of the stock is less than or equal to its price on the current day.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains N integers - the elements of the array, ith element denotes the stock price on ith day.

Constraints

1 <= T <= 200
1 <= N <= 104
0 <= A[i] <= 104

Output Format

For each test case, print space-separated Stock Span Array, separated by new line.

Sample Input 0

2
7
100 80 60 70 60 75 85 
10
0 7 3 6 6 9 18 0 16 0 
Sample Output 0

1 1 1 2 1 4 6 
1 2 1 2 3 6 7 1 2 1
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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
            
            int stack[] = new int[n], top = -1;
            int left_max[] = new int[n];
            for(int i=n-1;i>=0;i--) {
                while(top!=-1 && arr[stack[top]] < arr[i]) {
                    left_max[stack[top--]] = i;
                }
                stack[++top] = i;
                
            }
            
            while(top!=-1) {
                left_max[stack[top--]] = -1;
            }
            
            for(int i=0;i<n;i++) {
                System.out.print ((i-left_max[i])+" ");
            }
            
            System.out.println();
        }
    
    }
}
