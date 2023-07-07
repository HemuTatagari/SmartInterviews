/*
Farmer John has built a new long barn, with N stalls. The stalls are located along a straight line at positions x1,x2,x3,...,xN.

His C cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, first line contains 2 space separated integers - N and C. The second contains N integers, where ith integer denotes xi, location of the ith stall.

Constraints

1 <= T <= 100
1 <= N <= 104
1 <= C <= N
0 <= xi <= 106

Output Format

For each test case, print the largest minimum distance possible, separated by newline.

Sample Input 0

1
5 3
1 2 4 8 9 
Sample Output 0

3
Explanation 0

The cows should be placed at 1,4,9, which makes the minimum distance between them as 3. Any other combination will give a smaller minimum distance.

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
            long k = sc.nextLong();
            long arr[] = new long[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextLong();
            }
            
            Arrays.sort(arr);
            if(k==1) {
                System.out.println(0);
            }
            else {
            System.out.println(partition(arr,k,n));
            }
            
            
        }
    }
    
    public static long partition(long[] arr,long k,int n) {
        long low = 0, high = arr[n-1] , ans = -1;
        while(low <= high) {
            long mid = (low+high)/2;
            
            if(valid(arr,mid,k,n)) {
                ans = mid;
                low = mid + 1;  
            }
            else {
                high = mid-1 ;
            }
        }
        
        return ans;
    }
    
    public static boolean valid(long[] arr, long mid, long k,int n) {
        long count = 1, prev = arr[0];
        
        for(int i=1;i<n;i++) {
            if(arr[i] - prev >= mid) {
                prev = arr[i];
                count++;
            }
            
            if(count==k) {
                return true;
            }
        }
        //System.out.println(count);
       return false;
    }
}
