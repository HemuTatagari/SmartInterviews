/*

Given an array of unique elements, construct a Binary Search Tree. Now, given two nodes u and v of the BST, find their Lowest Common Ancestor (LCA). LCA is defined as the furthest node from the root that is an ancestor for both u and v.

Input Format

First line of input contains T - number of test cases. First line of each test case contains N, Q - number of nodes in the BST and the number of queries. The next line contains N unique integers - value of the nodes. Its followed by Q lines, each contains 2 nodes of the tree, u and v.

Constraints

1 <= T <= 1000
1 <= N,Q <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, for each query print the LCA of the given nodes u and v, separated by space. Separate the output of different test cases with a newline.

Sample Input 0

2
5 2
3 2 4 1 5
2 5
1 2
7 3
4 5 15 0 1 7 17
0 15
7 17
17 4
Sample Output 0

3 2 
4 15 4 
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;

public class Solution {

    static class TreeNode {
        int data,depth;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
         Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            TreeNode root = null;
            for(int i=0;i<n;i++) {
                root = insertNode(root,sc.nextInt());
            }
            while(q-- > 0) {
                TreeNode leastAncestor = findLeastAncestor(root,sc.nextInt(),sc.nextInt());
                System.out.print(leastAncestor.data+" ");
            }
            System.out.println();
        }
    }
    
    public static TreeNode findLeastAncestor(TreeNode root,int u, int v) {
        if(root == null) {
            return root;
        }
        if(root.data < u && root.data < v) {
            return findLeastAncestor(root.right,u,v);
        }
        else if(root.data > u && root.data > v) {
            return findLeastAncestor(root.left,u,v);
        }
        return root;
    }
    
    public static TreeNode insertNode(TreeNode root, int ele) {
        if(root == null) {
            return new TreeNode(ele);
        }
        if(root.data < ele) {
            root.right = insertNode(root.right,ele);
        }
        else {
            root.left = insertNode(root.left,ele);
        }
        return root;
    }
}
