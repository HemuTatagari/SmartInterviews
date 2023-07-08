/*

Given an array of integers of size N and a window size K. For each continuous window of size K, find the highest element in the window. Output the sum of the highest element of all the windows.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N and K - the size of the array and the window size K. The second line contains N integers - the elements of the array.

Constraints

30 points
1 <= T <= 1000
1 <= N <= 1000
1 <= K <= N
-104 <= A[i] <= 104

70 points
1 <= T <= 1000
1 <= N <= 10000
1 <= K <= N
-104 <= A[i] <= 104

Output Format

For each test case, print the sum of the highest element of all the windows of size K, separated by new line.

Sample Input 0

2
7 3
4 10 54 11 8 7 9 
4 2
11 15 12 9 
Sample Output 0

182
42
Explanation 0

Test Case 1
Window [4 10 54] : maximum element = 54
Window [10 54 11] : maximum element = 54
Window [54 11 8] : maximum element = 54
Window [11 8 7] : maximum element = 11
Window [8 7 9] : maximum element = 9
Total Sum = 54 + 54 + 54 + 11 + 9 = 182

Test Case 2
Window [11 15] : maximum element = 15
Window [15 12] : maximum element = 15
Window [12 9] : maximum element = 12
Total Sum = 15 + 15 + 12 = 42

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
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            
            int[] deque = new int[n];
            int  front = -1, rear = -1;
            
            for(int i=0;i<k;i++) {
                while(rear!=-1 && deque[rear] < arr[i]) {
                    rear--;
                }
                deque[++rear] = arr[i];
                if(front == -1) {
                    front = 0;
                }
            }
            
            int sum = deque[front];
            for(int i=k;i<n;i++) {
                if(arr[i-k] == deque[front]) {
                    front++;
                }
                while((front!=rear+1) && deque[rear] < arr[i]) {
                    rear--;
                }
                deque[++rear] = arr[i];
                 sum += deque[front];
                
            }
            System.out.println(sum);
        }
    }
}
