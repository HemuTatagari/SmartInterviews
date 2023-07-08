/*

Given an undirected, acyclic connected graph, find the length of the longest path in the graph.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - number of nodes and M - number of edges. Its followed by M lines, each contains a pair (u,v) - denoting an undirected edge between node u and node v.

Constraints

30 points
1 <= T <= 1000
1 <= N <= 100
1 <= u,v <= N

70 points
1 <= T <= 1000
1 <= N <= 10000
1 <= u,v <= N

Output Format

For each test case, print the length of the longest path in the graph, separated by newline.

Sample Input 0

2
8 7
7 4
6 1
6 5
3 4
1 2
1 3
1 8
11 10
1 5
5 3
4 1
9 1
10 4
2 10
7 2
6 10
11 4
1 8
Sample Output 0

5
6
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
            int m = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0;i<n+1;i++) {
                graph.add(new ArrayList<Integer>());
            }
            for(int i=0;i<m;i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            int[] dis = new int[n+1];
            for(int i=0;i<=n;i++){
                dis[i] = Integer.MAX_VALUE;
            }
            int endNode = bfs(dis,graph,1,true);
            for(int i=0;i<=n;i++){
                dis[i] = Integer.MAX_VALUE;
            }
            
            int longestPath = bfs(dis,graph,endNode,false);
            System.out.println(longestPath);
        }
    }
    
    public static int bfs(int[] dis, ArrayList<ArrayList<Integer>> graph, int src, boolean flag) {
        ArrayList<Integer> q = new ArrayList<>();
        q.add(src);
        dis[src] = 0;
        int x = 0;
        while(q.size()!=0) {
            x = q.get(0);
            q.remove(0);
            for(int num : graph.get(x)) {
                if(dis[num] == Integer.MAX_VALUE) {
                    q.add(num);
                    dis[num] = dis[x]+1;
                }
                
            }
            
        }
        if(flag == true) {
            return x;
        }
        else {
            return dis[x];
        }
    }
}
