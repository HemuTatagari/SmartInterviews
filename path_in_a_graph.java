/*

Given an undirected graph, you have to find if there exists a path between 2 given nodes of the graph.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N - number of nodes and M - number of edges. Its followed by M lines, each contains a pair (u,v) - denoting an undirected edge between node u and node v. The next line contains Q - number of queries. Its followed by Q lines, each contains a pair (u,v) - denoting an query to check if there exits a path between node u and node v.

Constraints

1 <= T <= 1000
1 <= N <= 100
0 <= M,Q <= min(N*N, 100)
1 <= u,v <= N

Output Format

For each test case, first print the test case number as shown. For each query of a test case, print "Yes" if path exists between the nodes of the query, print "No" otherwise, separated by newline.

Sample Input 0

2
5 3
1 3
2 4
3 2
4
1 5
3 4
4 5
1 4
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
5
2 4
8 4
9 10
10 5
9 7
Sample Output 0

Test Case #1:
No
Yes
No
Yes
Test Case #2:
Yes
No
Yes
No
No
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cases = 1;
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
            
            System.out.println("Test Case #"+cases+":");
            cases++;
            
            int q = sc.nextInt();
            for(int i=0;i<q;i++) {
                int src = sc.nextInt();
                int des = sc.nextInt();
                boolean res = BFS(graph, n, src, des);
                if(res == true) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
            
        }
    }
    
    public static boolean BFS(ArrayList<ArrayList<Integer>> graph,int n, int src, int des) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(src);
        visited[src] = true;
        while(queue.size() != 0) {
            int x = queue.poll();
            if(x == des) {
                return true;
            }
            for(int num : graph.get(x)) {
                if(visited[num] == false) {
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }
        return false;
    }
}
