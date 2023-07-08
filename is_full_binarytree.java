/*

Given an array of unique elements, construct a Binary Search Tree and check if its a Full Binary Tree [FBT]. A FBT is one in which each node is either a leaf or possesses exactly 2 child nodes.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print "True" if the Binary Search Tree is a FBT, "False" otherwise, separated by newline.

Sample Input 0

3
5
1 2 3 4 5 
11
8 3 30 15 40 18 12 17 25 1 7 
7
4 5 15 0 1 7 17 
Sample Output 0

False
True
False
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
            TreeNode root = null;
            for(int i=0;i<n;i++) {
                root = insertNode(root,sc.nextInt());
            }
           
            System.out.println(isFullBinaryTree(root) == true ? "True" : "False");
        }
    }
    
    public static boolean isFullBinaryTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        if((root.left == null && root.right != null) || (root.right==null && root.left!=null) ) {
            return false;
        }
        
        return isFullBinaryTree(root.left)&&isFullBinaryTree(root.right);
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
