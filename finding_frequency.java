/*

Given an array, you have to find the frequency of a number x.

Input Format

First line of input contains N - size of the array. The next line contains N integers, the elements of the array. The next line contains Q - number of queries. Each of the next Q lines contains a single integer X, for which you have to find the frequency of X in the given array.

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

For each query, print the frequency of X, separated by newline.

Sample Input 0

9
-6 10 -1 20 -1 15 5 -1 15 
5
-1
10
8
15
20
Sample Output 0

3
1
0
2
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
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i]= sc.nextInt();
        }
        Arrays.sort(arr);
        int T = sc.nextInt();
        while(T-- > 0) {
            int q = sc.nextInt();
            int p1 = floorBin(arr,q);
            int p2 = ceilBin(arr,q);
            if(p2 == 0 & p1 == 0) {
                System.out.println(0);
            }
            else {
            System.out.println(p2-p1+1);
            }
        }
    }
    
    public static int floorBin(int[] arr, int n) {
        int low = 0, high = arr.length-1,p1 = 0,mid;
        while(low<=high) {
            mid = (low+high) /2;
            if(arr[mid] == n) {
                p1 = mid;
                high = mid-1;
            }
            
            else if(arr[mid] > n) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        return p1;
    }
    
    public static int ceilBin(int[] arr, int n) {
        int low = 0, high = arr.length-1,p2 = 0,mid;
        while(low<=high) {
            mid = (low+high) /2;
            if(arr[mid] == n) {
                p2 = mid;
                low=mid+1;
            }
            
            else if(arr[mid] > n) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
            
        }
        return p2;
    }
    
    
    
}
