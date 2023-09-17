/*

You are given an array of 0's and 1's. Find the length of the longest subarray which has an equal number of 0's and 1's.

Input Format

First line of input contains T - the number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

10 points
1 <= T <= 100
1 <= N <= 100

20 points
1 <= T <= 100
1 <= N <= 1000

70 points
1 <= T <= 1000
1 <= N <= 104

Output Format

For each test case, print the length of the longest subarray which has equal 0's and 1's, separated by a new line.

Sample Input 0

2
5
0 1 1 0 1
6
1 1 1 1 1 0
Sample Output 0

4
2
Explanation 0

Self Explanatory

  */

// note :- used Fast I/O template


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i]=sc.nextInt();
            
            //code
            
            //replacing 0 with -1 =====> [0 => -1]
            for(int i=0;i<n;i++) {
                if(arr[i] == 0) arr[i]=-1;
            }
            
            //prefix sum array
            for(int i=1;i<n;i++) {
                arr[i]+=arr[i-1];
            }
            
            //calculating maxSubarray with equal 0s and 1s
            int maxLength = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,-1);
            for(int i=0;i<n;i++){
                if(map.containsKey(arr[i])) {
                    maxLength = Math.max(maxLength, i-map.get(arr[i]));
                }
                else {
                    map.put(arr[i],i);
                }
            }
            System.out.println(maxLength);
            t-=1;
        }
    }
}
