/*

You are given an integer array and a positive integer K. You have to tell if there exists a pair of integers in the given array such that ar[i]-ar[j]=K and i≠j.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N and K - the size of the array and the number K. The second line contains the elements of the array.

Constraints

40 points
2 <= N <= 1000

60 points
2 <= N <= 100000

General Constraints
1 <= T <= 100
-105 <= ar[i], K <= 105

Output Format

For each test case, print "true" if the arrays contains such elements, false otherwise, separated by new line.

Sample Input 0

2
5 60
1 20 40 100 80 
10 11
12 45 52 65 21 645 234 14 575 112 
Sample Output 0

true
false
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
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = false;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<arr.length;i++) {
                if(map.containsKey(k+arr[i]) || map.containsKey(-1*(k-arr[i]))) {
                    flag = true;
                }
                else {
                    map.put(arr[i],i);
                }
            }
            
            System.out.println(flag);
        }
        
    }
}
