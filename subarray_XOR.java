/*

You are given an array of integers of size N. Find the maximum subarray XOR value.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

20 points
1 <= N <= 103

80 points
1 <= N <= 105

General Constraints
1 <= T <= 100
0 <= A[i] <= 105

Output Format

For each test case, print the result, separated by a newline.

Sample Input 0

3
3
6 3 11 
8
34 10 10 10 2 8 3 4 
7
7 9 2 5 8 2 4 
Sample Output 0

14
42
15
Explanation 0

Test Case 1
The subarrays are:
[6] : 6
[6 ^ 3] : 5
[6 ^ 3 ^ 11] : 14
[3] : 3
[3 ^ 11] : 8
[11] : 11

The maximum XOR value is 14.

*/


import java.io.*;
import java.util.*;

public class Solution {
    
    static class Trie {
        Trie[] child = new Trie[2];
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            int max_ele = Integer.MIN_VALUE;
            
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                max_ele = Math.max(max_ele, arr[i]);
            }
            
            int bits =(int) (Math.log(max_ele) / Math.log(2));
            
            Trie root = new Trie();
            int a = 0;
            int maxx = Integer.MIN_VALUE;
            
            for(int num : arr) {
                insert(bits, root, a);
                a = a^num;
                maxx = Math.max(maxx, findMaxXor(bits, root, a));
            }
            
            System.out.println(maxx);
        }
    }
    
                                
    public static void insert(int bits, Trie root, int num) {
        for(int i=bits;i>=0;i--) {
            int bit_val = ((num>>i) & 1);
            if(root.child[bit_val] == null) {
                root.child[bit_val] = new Trie();
            }
            root = root.child[bit_val];
        }
    }
    
    public static int findMaxXor(int bits, Trie root, int num) {
        int sum = 0;
        for(int i=bits;i>=0;i--) {
            int bit_val = ((num>>i)&1);
            if(root.child[1-bit_val] != null) {
                sum+= (1<<i);
                root = root.child[1-bit_val];
            }
            else {
                root = root.child[bit_val];
            }
        }
        return sum;
    }
}
