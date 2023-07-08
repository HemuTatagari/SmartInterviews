/*

The famous knapsack problem. You are packing for a vacation on the sea side and you are going to carry only one bag with capacity S. You also have N items that you might want to take with you to the sea side. Unfortunately you can not fit all of them in the knapsack so you will have to choose. For each item you are given its size and its value. You want to maximize the total value of all the items you are going to bring. What is this maximum total value?.

Input Format

First line of input contains T - number of test cases. First line of each test case contains - S and N. N lines follow with two integers on each line describing one of your items. The first number is the size of the item and the next is the value of the item.

Constraints

20 points
1 <= T <= 100
1 <= N <= 20

80 points
1 <= T <= 1000
1 <= N <= 500

General Constraints
1 <= S <= 500
1 <= W[i] <= 50
0 <= V[i] <= 1000

Output Format

For each test case, print the total maximum value from the best choice of items for your trip, separated by newline.

Sample Input 0

2
4 5
1 8
2 4
3 0
2 5
2 3
106 5
52 298
89 123
6 882
53 566
17 337
Sample Output 0

13
1785
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int s = sc.nextInt();
            int n = sc.nextInt();
            
            int[] weights = new int[n];
            int[] values = new int[n];
            for(int i=0;i<n;i++){
                weights[i] = sc.nextInt();
                values[i] = sc.nextInt();
            }
            
            int[][] dp = new int[n+1][s+1];
            for(int i=1;i<n+1;i++) {
                for(int j=1;j<s+1;j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j >= weights[i-1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                    }
                }
            }
            
            System.out.println(dp[n][s]);
            
        }
    }
}
