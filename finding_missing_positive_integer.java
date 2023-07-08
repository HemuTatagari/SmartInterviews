/*

You are given an array of integers of size N. Find the first positive integer that is missing from the array.
Note: Try solving in O(N) time without using any additional space, except the input array.

Input Format

First line of input contains T - number of test cases. For each test case, the first line contains one integer N - the size of the array. The second line contains N integers - the elements of the array.

Constraints

1 <= T <= 100
1 <= N <= 105
-105 <= A[i] <= 105

Output Format

For each test case, print the first missing postive integer, separated by a newline.

Sample Input 0

2
5
2 0 1 5 -3
6
2 -7 3 1 8 -1
Sample Output 0

3
4
Explanation 0

Test-Case 1
The first missing positive integer is 3, as 1 and 2 are present in the array.

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
       int t= sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int x=n+100;
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            for(int ind=0;ind<n;ind++)
            {
                // if(arr[ind]<0 || arr[ind]>n) '0 bhi positive nai hain na...tho arr[ind]<=0 hona chahiye'
                if(arr[ind]<=0 || arr[ind]>n)
                {
                    //arr[ind]=arr[ind]+x;
                    arr[ind] = x;
                }
            }
            for(int j=0;j<n;j++)
            {
                int num=arr[j];
                // 
                if(arr[j]<0) {
                    num = -1*num;
                }
                
                //
                if (num>0 && num<n)
                {
                    //
                    if(arr[num-1]>0) {
                        arr[num-1]=-arr[num-1];
                    }
                }
            }
            for(int ind=0;ind<n;ind++)
            {
                if(arr[ind]>0)
                {
                   System.out.println(ind+1);
                    break;
                }
            }

            t=t-1;
        }
    }
}
