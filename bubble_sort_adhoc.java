/*
mplement Bubble Sort and print the total number of swaps involved to sort the array.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - size of the array. The next line contains N integers - elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 100
-1000 <= ar[i] <= 1000

Output Format

For each test case, print the total number of swaps, separated by new line.

Sample Input 0

4
8
176 -272 -272 -45 269 -327 -945 176 
2
-274 161
7
274 204 -161 481 -606 -767 -351
2
154 -109
Sample Output 0

15
0
16
1
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
            
            int res = 0;
            int temp = 0;
            for(int i=0;i<n;i++) {
                for(int j=0; j<n-i-1;j++) {
                    if(arr[j] > arr[j+1]) {
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        res++;
                    }
                    
                }
            }
            System.out.println(res);
        }
    }
}
