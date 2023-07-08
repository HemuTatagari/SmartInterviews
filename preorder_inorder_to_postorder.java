/*

Given the preorder and inorder traversals of a binary tree with unique elements, print the PostOrder Traversals of the tree.

Input Format

First line of input contains T - number of test cases. Its followed by 3T lines. First line of each test case contains N - number of nodes in the binary tree. Second line contains N unique integers denoting the preorder traversal of the tree. Third line contains N unique integers denoting the inorder traversal of the tree.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the PostOrder Traversal of the Binary Tree, separated by newline.

Sample Input 0

3
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
10
8 5 9 7 1 12 2 4 11 3 
9 5 1 7 2 12 8 4 3 11 
9
2 7 3 6 8 11 5 9 4 
3 7 8 6 11 2 5 4 9 
Sample Output 0

4 5 2 6 7 3 1 
9 1 2 12 7 5 3 11 4 8 
3 8 11 6 7 4 9 5 2 
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
            int[] pre_order = new int[n];
            HashMap<Integer,Integer> in_order = new HashMap<>();
            
            for(int i=0;i<n;i++) {
                pre_order[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++) {
                in_order.put(sc.nextInt(),i);
            }
            
            TreeNode root = getPostOrder(pre_order,in_order,0,n-1,0,n-1);
            postOrder(root);
            System.out.println();
        }
    }
        
        public static TreeNode getPostOrder(int[] pre_order, HashMap<Integer,Integer> in_order, int pre_start, int pre_end, int in_start, int in_end) {
            if(in_start > in_end || pre_start > pre_end) {
                return null;
            }
            int ele = pre_order[pre_start];
            int index = in_order.get(ele);
            
            TreeNode root = new TreeNode(ele);
            root.left = getPostOrder(pre_order,in_order,pre_start + 1,(pre_start + index - in_start), in_start ,index-1);
            root.right = getPostOrder(pre_order,in_order,(pre_start+index - in_start +1),pre_end,index+1,in_end);
            
            return root;
        }
    
    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print (root.data+" ");

    }
    
}
