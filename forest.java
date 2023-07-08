/*

Given an undirected graph, determine if the given graph is a forest. A forest is a disjoint union of trees. A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any acyclic connected graph is a tree.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - number of nodes and M - number of edges. Its followed by M lines, each contains a pair (u,v) - denoting an undirected edge between node u and node v.

Constraints

1 <= T <= 1000
1 <= N <= 10000
1 <= M <= N
1 <= u,v <= N

Output Format

For each test case, print "Yes" if the graph is a forest, print "No" otherwise, separated by newline.

Sample Input 0

4
5 4
1 3
2 3
4 5
2 1
5 3
1 3
2 3
4 5
5 4
1 2
3 4
1 3
4 5
6 5
1 4
2 4
3 5
5 6
2 1
Sample Output 0

No
Yes
Yes
No
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
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
            if(m == n-connectedComponents) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
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
