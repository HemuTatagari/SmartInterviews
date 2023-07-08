/*

Given an undirected graph, you have to find the number of connected components in the graph.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - number of nodes and M - number of edges. Its followed by M lines, each contains a pair (u,v) - denoting an undirected edge between node u and node v.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= M <= min(N*N, 1000)
1 <= u,v <= N

Output Format

For each test case, print the number of connected components, separated by newline.

Sample Input 0

2
5 3
1 3
2 4
3 2
10 9
3 4
5 1
2 5
4 6
2 3
6 3
1 4
8 9
8 10
Sample Output 0

2
3
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
            boolean[] visited = new boolean[n+1];
            int connectedComponents = 0;
            for(int i=1;i<n+1;i++) {
                if(visited[i] == false) {
                    connectedComponents+=1;
                    BFS(graph, visited,i);
                }
            }
            System.out.println(connectedComponents);
        }
    }
    
    public static void BFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int src){
        ArrayList<Integer> q = new ArrayList<>();
        q.add(src);
        visited[src] = true;
        while(q.size()!=0){
            int x = q.get(0);
            q.remove(0);
            for(int num : graph.get(x)) {
                if(visited[num] == false) {
                    visited[num] = true;
                    q.add(num);
                }
            }
        }
        
    }
}
