/*

You are given an array of integers. Find the sum of XOR of all pairs formed by the elements of the array.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

20 points
1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 105

80 points
1 <= T <= 100
1 <= N <= 105
0 <= A[i] <= 105

Output Format

For each test case, print the sum of XOR of all pairs formed by the elements of the array, separated by a newline.

Sample Input 0

3
3
5 12 8 
5
4 10 54 11 8 
6
15 35 25 10 15 12 
Sample Output 0

52
560
680
Explanation 0

Test Case 1

XOR of all pairs will be:
(5 ^ 5) = 0
(5 ^ 12) = 9
(5 ^ 8) = 13
(12 ^ 5) = 9
(12 ^ 12) = 0
(12 ^ 8) = 4
(8 ^ 5) = 13
(8 ^ 12) = 4
(8 ^ 8) = 0

Sum of all the above = 52

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
            for(int i=0; i<n;i++) {
                arr[i] = sc.nextInt();
            }
            long res = 0;
            
            for(int i=0;i<32;i++) {
                long zc = 0, oc = 0;
                for(int j=0;j<n;j++) {
                    if(setBit(arr[j],i)){
                        oc ++;
                    }
                    else {
                        zc++;
                    }
                }
                
                res = res + (zc * oc * (1 << i));
            }
            
            System.out.println(res*2);
            
        }
        
        
    }
    
    public static boolean setBit(int n, int i) {
        if((n&(1<<i)) !=0) {
            return true;
        }
        return false;
    }
}
