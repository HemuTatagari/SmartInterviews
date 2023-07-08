/*

You are given two integers L, R and an array of unique elements, construct a Binary Search Tree from the array and then trim the BST in a manner such that all its elements lie between [L, R].
Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines.
First line of each test case contains three integers, N - number of nodes in the BST, L - the lower limit of the range and R - the upper limit of the range. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the preorder traversal of the trimmed tree, separated by newline.

Sample Input 0

3
5 2 4
1 2 3 4 5
5 1 4
3 2 4 1 5
7 2 10
4 5 15 0 1 7 17
Sample Output 0

2 3 4
3 2 1 4
4 5 7
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
            int lowerRange = sc.nextInt();
            int higherRange = sc.nextInt();
            TreeNode root = null;
            for(int i=0;i<n;i++) {
                root = insertNode(root,sc.nextInt());
            }
           
            preOrder(trimBST(root,lowerRange,higherRange));
            System.out.println();
        }
    }
    
    public static TreeNode trimBST(TreeNode root, int l, int r) {
        if(root == null) {
            return null;
        }
        if(root.data < l) {
            return trimBST(root.right,l,r);
        }
        if(root.data > r) {
            return trimBST(root.left,l,r);
        }
        
        root.left = trimBST(root.left,l,r);
        root.right = trimBST(root.right,l,r);
        
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

