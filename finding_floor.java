
/*
Given an array, you have to find the floor of a number x. The floor of a number x is nothing but the largest number in the array less than or equal to x.

Input Format

First line of input contains N - size of the array. The next line contains N integers, the elements of the array. The next line contains Q - number of queries. Each of the next Q lines contains a single integer X, for which you have to find the floor of X in the given array.

Constraints

30 points
1 <= N <= 105
1 <= Q <= 102
-108 <= ar[i] <= 108

70 points
1 <= N <= 105
1 <= Q <= 105
-108 <= ar[i] <= 108

Output Format

For each query, print the floor of X, separated by newline. If floor not found, print the value of "INT_MIN"

Sample Input 0

6
-6 10 -1 20 15 5 
5
-1
10
8
-10
-4
Sample Output 0

-1
10
5
-2147483648
-6
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int T = sc.nextInt();
        while(T-- > 0) {
            int k = sc.nextInt();
            int low = 0, high = n-1, mid = 0,ans = 25000;
            boolean flag = true;
            while(low <= high) {
                mid = (low+high)/2;
                if(arr[mid] == k) {
                    System.out.println(arr[mid]);
                    flag = false;
                    break;
                }
                
                if(arr[mid] > k) {
                    high = mid -1;
                }
                else {
                    ans = arr[mid];
                    low = mid+1;
                }
            }
            if(flag) {
                if(ans == 25000) {
                    System.out.println(-2147483648);
                }
                else {
                    System.out.println(ans);
                }
            }
        }
        
        
        
    }
}
