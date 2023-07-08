/*

In a Stock exchange, you know the selling price of a share in advance. You wish to maximise the duration between which you book profits. You don't care about making too big a profit but profit should be made and at the same time, the duration between buy and sell should be the largest. Write an algorithm to find the days on which to buy and sell.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the number of days for which the share prices are known and second line contains N elements, where the ith element denotes the share price on ith day.

Constraints

30 points
1 <= T <= 500
2 <= N <= 102
1 <= arr[i] <= 104

70 points
1 <= T <= 500
2 <= N <= 104
1 <= arr[i] <= 106

Output Format

For each test case, print the maximum duration along with the profit, separated by new line. If there are multiple answers with same maximum duration, print the answer with maximum profit. If it is impossible to make profit, print -1.

Sample Input 0

2
10
9 2 3 4 5 6 7 8 25 1 
9
34 8 10 3 2 30 80 33 1 
Sample Output 0

8 16
6 46
Explanation 0

Test Case 1
The maximum possible duration here is 8 (Buy on Day-1 with price=9 and sell on Day-9 with price=25). So the answer is Duration=8, Profit=16.


Test Case 2
The maximum possible duration is 6 with 2 possibilities:
1. Buy on Day-2 with price=8 and sell on Day-8 with price=33 : Profit=25
2. Buy on Day-1 with price=34 and sell on Day-7 with price=80 : Profit=46
So the answer is Duration=6, Profit=46.

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-- > 0) {
            int n= sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            
            int[] sorted_arr = new int[n];
            int[] sorted_index = new int[n];
            
            for(int i=0;i<n;i++) {
                sorted_arr[i] = arr[i];
                sorted_index[i] = i;
            }
            
            quickSort(sorted_arr,sorted_index,0,n-1);
            
            //to get right maxx array
            int[] right_max = new int[n];
            int[] stack = new int[n];
            
            int sortIndex = 0, mainIndex = n-1;
            while(sortIndex < n) {
                while(mainIndex >= 0 && arr[mainIndex]<=sorted_arr[sortIndex] && mainIndex > sorted_index[sortIndex]) {
                    mainIndex--;
                }
                
                if(mainIndex >= 0 && mainIndex > sorted_index[sortIndex]) {
                    right_max[sorted_index[sortIndex]] = mainIndex;
                }
                sortIndex++;
            }
             
            // to calculate maxxStock and maxxProfit
            int max_profit = 0, max_duration = 0;
            for(int i=0;i<n;i++) {
                if(right_max[i]-i > max_duration) {
                    max_profit = arr[right_max[i]] - arr[i];
                    max_duration = right_max[i] - i;
                }
                else if(right_max[i]-i == max_duration) {
                    max_profit = Math.max(max_profit, arr[right_max[i]] - arr[i]);
                }
            }
            
            // output
            if(max_profit == 0) {
                System.out.println(-1);
            }
            else {
                System.out.println(max_duration+" "+max_profit);
            }
        }
    }
    
    public static void quickSort(int a[], int[] s, int start, int end)  
    {  
        if (start < end)  
        {  
            int p = partition(a, s, start, end);   
            quickSort(a, s, start, p - 1);  
            quickSort(a, s,  p + 1, end);  
        }  
    }  
    
    public static int partition (int a[],int[] s, int start, int end)  
    {  
        int pivot = a[end];   
        int i = (start - 1);  
  
        for (int j = start; j <= end - 1; j++)  
        {  
          
            if (a[j] < pivot)  
            {  
                i++;  
                
                swap(a,i,j); //sorted array swapping
                swap(s,i,j); // sorted index swapping
            }  
        }  
         
        swap(a,i+1,end); //sorted array swapping
        swap(s,i+1,end); // sorted index swapping
        
        return (i + 1);  
    } 
    
    public static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return;
    }
}
