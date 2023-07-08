/*

You are given a array containing only 0s and 1s . You have to tell the number of subarrays which has equal number of 0s and 1s.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines - the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

40 points
1 <= T <= 100
1 <= N <= 100

60 points
1 <= T <= 100
1 <= N <= 1000

100 points
1 <= T <= 100
1 <= N <= 50000

Output Format

For each test case, output the number of subarrays having equal numer of 0s and 1s, separated by new line.

Sample Input 0

3
4
1 0 1 0 
10
1 0 1 0 0 1 0 0 1 1 
4
1 1 1 1 
Sample Output 0

4
14
0
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
            
            //input
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
                if(arr[i] == 0) {
                    arr[i] = -1;
                }
            }
            
            //prefix sum array
            int prefix_sum[] = new int[n];
            prefix_sum[0] = arr[0];
            for(int i=1;i<n;i++) {
                prefix_sum[i] = prefix_sum[i-1]+arr[i];
            }
            
            //counting using HashMap
            int validCount = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            
            for(int i=0;i<n;i++) {
                map.put(prefix_sum[i],map.getOrDefault(prefix_sum[i],0)+1);
                validCount+= map.get(prefix_sum[i])-1;
            }
            
            //output
            System.out.println(validCount);
        }
    }
}
