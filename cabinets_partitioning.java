/*

You are given a job which has been divide into N tasks. The task cannot be divided any further. Each of the N tasks takes Si number of seconds to complete. Your job will be completed when all your tasks are completed. You have K workers at your disposal to help you complete the tasks. But as per the nature of the job, a worker can only be allocated continuous tasks. A worker can work only on a single task at any given point of time. However, the workers can work in parallel on different tasks. You have to find the minimum possible time in which you can complete the job.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N and K - number of tasks and available workers for the current job, separated by space. The next line contains N positive integers - denoting the time taken to complete the ith task.

Constraints

50 points
1 <= N,K <= 20

150 points
1 <= N,K <= 10000

General Constraints
1 <= T <= 50
1 <= Si <= 103

Output Format

For each test case, print the minimum possible time in which you can complete the job, separated by newline.

Sample Input 0

6
10 3
1 10 13 4 5 12 23 12 18 8 
8 4
17 27 22 45 26 32 45 16 
2 2
74 61 
7 3
74 24 61 81 66 76 51 
2 1
54 10 
4 2
15 30 10 50 
Sample Output 0

38
66
74
159
64
55
Explanation 0

Self Explanatory

*/

import java.io.*;
import java.util.*;

public class Solution {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            
            System.out.println(partition(arr,n,k));
        }
    
    }
    
    public static int partition(int[] arr, int n, int k){
        int low = max(arr), high = sum(arr), mid = 0;
        /*if(n == k) {
            return max(arr);
        }
        
        if(k == 1) {
            return sum(arr);
        }*/
        while(low < high) {
            mid = (low+high)/2;
            if(valid(arr,mid,n,k)) {
                high = mid ;
                
            }
            else {
                low = mid + 1;
            }
        }
        
        return low;
        
    }
    
    public static boolean valid(int arr[], int mid, int n,int k) {
        int count =1, sum = 0;
        for(int i=0;i<n;i++) {
            if(sum + arr[i] <= mid) {
                sum+=arr[i];
            }
            else {
                count ++;
                sum = arr[i];
            }
        }
        
        return count <= k;
    }
    
    public static int max(int[] arr) {
        int res = arr[0];
        for(int i=1;i<arr.length;i++) {
            if(res < arr[i]) {
                res = arr[i];
            }
        }
        return res;
    }
    
    public static int sum(int[] arr) {
        int res = 0;
        for(int i=0;i<arr.length;i++) {
            res+=arr[i];
        }
        return res;
    }
    
    
}
