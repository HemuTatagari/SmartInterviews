/*

You are given a 2D matrix consisting of the following:
1: land
0: water
Considering N-8 neighbourhood, your task is to find the number of islands in the given landscape.
Assume that the the 2D matrix is surrounded by water beyond the boundaries.

Definitions:
N-8 neighbourhood: 2 cells are considered neighbours, if they share an edge or a corner.
Island: A piece of connected land surrounded by water.

Input Format

First line of input contains T - number of test cases. The first line of each test case contains R, C - the size of the matrix. Its followed by a matrix of size RxC, consisting only of 0s and 1s.

Constraints

1 <= T <= 100
1 <= R,C <= 500

Output Format

For each test case, print the total number of islands, separated by new line.

Sample Input 0

3
4 8
01001101
10001010
00100100
01101101
6 1
0
1
0
0
1
1
9 5
00000
10001
00110
01100
10000
00000
00101
00011
00110
Sample Output 0

4
2
3
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
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            char[][] graph = new char[n][m];
            
            for(int i=0;i<n;i++) {
                String str = sc.next();
                for(int j=0;j<m;j++) {
                    graph[i][j] = str.charAt(j);
                }
            }
            int count = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                     if(graph[i][j] == '1') {
                        DFS(graph,i,j,n,m);
                        count = count + 1;
                    }
                }
            }
           
            System.out.println(count); 
        }
    }
    
    public static void DFS(char[][] graph,int i, int j,int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || graph[i][j] == '0') {
            return;
        }
        int[] ii = {0,0,1,1,1,-1,-1,-1};
        int[] jj = {-1,1,0,-1,1,0,-1,1};
        graph[i][j] = '0';
        for(int k=0;k<8;k++) {
            DFS(graph,i+ii[k],j+jj[k],n,m);
        }
        
    }
    
    
}
