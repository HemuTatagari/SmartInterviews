/*

Given an array of unique elements, construct a Binary Search Tree and find the height of the tree.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the height of the Binary Search Tree, separated by newline.

Sample Input 0

3
5
1 2 3 4 5 
5
3 2 4 1 5 
7
4 5 15 0 1 7 17 
Sample Output 0

4
2
3
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;

public class Solution {
    
     static class TreeNode {
        int data;
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
            TreeNode root = null;
            for(int i=0;i<n;i++) {
                root = insertNode(root,sc.nextInt());
            }
            int[] maxx = new int[1];
            findHeight(root,maxx,0);
            System.out.println(maxx[0]-1);
        }
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
    
    public static void findHeight(TreeNode root,int[] maxx,int currHeight) {
        if(root == null) {
            maxx[0] = Math.max(maxx[0],currHeight);
            return;
        }
        findHeight(root.left,maxx,currHeight+1);
        findHeight(root.right,maxx,currHeight+1);
        
    }
}
