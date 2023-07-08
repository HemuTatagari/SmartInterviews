/*


Given an array of unique elements, construct a Binary Search Tree and print the PreOrder, InOrder and PostOrder Traversals of the tree.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the PreOrder, InOrder and PostOrder Traversals of the Binary Search Tree, separate each traversal by newline. Separate the output of different test cases with an extra newline.

Sample Input 0

3
5
1 2 3 4 5 
5
3 2 4 1 5 
7
4 5 15 0 1 7 17 
Sample Output 0

1 2 3 4 5 
1 2 3 4 5 
5 4 3 2 1 

3 2 1 4 5 
1 2 3 4 5 
1 2 5 4 3 

4 0 1 5 15 7 17 
0 1 4 5 7 15 17 
1 0 7 17 15 5 4 
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
            preOrder(root);
            System.out.println();
            
            inOrder(root);
            System.out.println();
            
            postOrder(root);
            System.out.println();
            
            System.out.println();
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
    
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        System.out.print (root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        System.out.print (root.data+" ");
        inOrder(root.right);
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
