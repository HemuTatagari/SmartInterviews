/*

There is a line of houses, where each house can be painted with one of the three colors: red, blue and green. The cost of painting each house with a certain color is different. Find the minimum cost to paint all the houses such that no two adjacent house have the same color.

Input Format

First line of input contains T - number of test cases. Its followed by 4T lines, the first line contains N - number of houses and the second, third and fourth line contains the costs of each house for red, green and blue respectively.

Constraints

1 <= T <= 100
1 <= N <= 103
1 <= R[i],G[i],B[i] <= 103

Output Format

For each test case, print the minimum cost, separated by newline.

Sample Input 0

1
6
7 3 8 6 1 2 
5 6 7 2 4 3 
10 1 4 9 7 6 
Sample Output 0

18
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
            int n = sc.nextInt();
            int[] red = new int[n];
            int[] blue = new int[n];
            int[] green = new int[n];
            
            for(int i=0;i<n;i++) {
                red[i] = sc.nextInt();
            }
            
            for(int i=0;i<n;i++) {
                green[i] = sc.nextInt();
            }
            
            for(int i=0;i<n;i++) {
                blue[i] = sc.nextInt();
            }
            
            int prev_red = 0, prev_green = 0, prev_blue = 0;
            for(int i=0;i<n;i++) {
                int curr_red = Math.min(prev_green, prev_blue) + red[i];
                int curr_green = Math.min(prev_red, prev_blue) + green[i];
                int curr_blue = Math.min(prev_red, prev_green) + blue[i];
                prev_red = curr_red;
                prev_green = curr_green;
                prev_blue = curr_blue;
            }
            
            System.out.println(Math.min(Math.min(prev_red, prev_green), prev_blue));
        }
    }
}
