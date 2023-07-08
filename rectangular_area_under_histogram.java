/*

Given height of adjacent buildings, find the largest rectangular area possible, where the largest rectangle can be made of a number of contiguous buildings. For simplicity, assume that all buildings have same width and the width is 1 unit.
Note: The sides of rectangle has to be parallel to the axes.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines - the first line contains N - the number of buildings. The second line contains the height of the buildings.

Constraints

50 points
1 <= T <= 100
1 <= N <= 103
1 <= A[i] <= 1000

150 points
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 104

Output Format

For each test case, print the area of the largest possible rectangle, separated by new line.

Sample Input 0

2
7
6 2 5 4 5 1 6 
4
5 10 12 4 
Sample Output 0

12
20
Explanation 0

Test Case 1

You can form the following rectangles:
6x1 = 6, 2x5 = 10, 5x1 = 5, 4x3 = 12, 5x1 = 5, 1x7 = 7, 6x1 = 6 : max = 12 [axb means rectangle with height a and width b]

Test Case 2

You can form the following rectangles:
5x3 = 15, 10x2 = 20, 12x1 = 12, 4x4 = 16 : max = 20 [axb means rectangle with height a and width b]

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
            int[] arr = new int[n];
            int[] left_min = new int[n];
            int[] right_min = new int[n];
            
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            Stack<Integer> s = new Stack<>();
            
            // to find right minimum array
            for(int i=0;i<n;i++) {
                
                while((!(s.empty())) && arr[s.peek()] > arr[i]) {
                    
                    right_min[s.pop()] = i;
                }
                s.push(i);
            }
            while(!(s.empty())) {
                right_min[s.pop()] = n;
            }
            
            // to find left min array
            for(int i=n-1;i>=0;i--) {
                while((!(s.empty())) && arr[s.peek()] > arr[i]) {
                    left_min[s.pop()] = i;
                }
                s.push(i);
            }
            while(!(s.empty())) {
                left_min[s.pop()] = -1;
            }
            
            
            
            // to find ans
            int ans = 0;
            for(int i=0;i<n;i++) {
                ans = Math.max(ans,(right_min[i] - left_min[i] - 1)*arr[i]);
            }
            
            System.out.println(ans);
        }
    }
}
