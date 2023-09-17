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
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            
            //code
            int maxxDuration = -1, maxxProfit = 0;
            for(int i=0;i<n;i++) {
                for(int j=n-1;j>i;j--) {
                    if(arr[j] > arr[i]) {
                        if(maxxDuration < j-i) {
                            maxxDuration = j-i;
                            maxxProfit = arr[j]-arr[i];
                        }
                        else if(maxxDuration== j-i) {
                            if(maxxProfit < arr[j]-arr[i]) {
                                maxxProfit = arr[j]-arr[i];
                            }
                        }
                        break;
                    }
                }
            }
            if(maxxProfit == 0) System.out.println("-1");
            else
                System.out.println(maxxDuration+" "+maxxProfit);
            t--;
        }
    }
}
