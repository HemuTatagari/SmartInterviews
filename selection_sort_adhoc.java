
/*
Implement Selection Sort and print the index which gets swapped at each step.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - size of the array. The next line contains N integers - elements of the array.

Constraints

1 <= T <= 100
2 <= N <= 100
-1000 <= ar[i] <= 1000


Output Format

For each test case, print the index which gets swapped at each step, separated by space. Separate the output of different tests by newline.

Sample Input 0

6
8
176 -272 -272 -45 269 -327 -945 176 
2
-274 161 
7
274 204 -161 481 -606 -767 -351 
2
154 -109 
4
5 3 1 5 
4
40 10 20 40 
Sample Output 0

4 0 4 3 1 2 1 
1 
3 0 1 2 2 1 
0 
0 0 1 
0 0 0 
Explanation 0

Self Explanatory

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
            int idx=0,temp;
           for(int i=n-1;i>0;i--) {
               idx = i;
               for(int j=i-1;j>=0;j--) {
                   if(arr[j] >= arr[idx]) {
                       idx = j;
                   }
               }
               temp = arr[i];
               arr[i] = arr[idx];
               arr[idx] = temp;
               
               
                System.out.print (idx+" ");
        
           }
            System.out.println();
        }
    }
}
