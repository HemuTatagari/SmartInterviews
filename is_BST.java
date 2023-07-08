/*

Given a binary tree with unique elements, check if its a Binary Search Tree.
The input is given in form of a complete binary tree, represented using an array. Assuming array index start from 1, root will be at index 1. For every index i, its child nodes will be at 2i and 2i+1.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the tree. The next line contains N integers - nodes of the binary tree in the form of a Complete Binary Tree.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print "True" if the given Binary Tree is a Binary Search Tree, "False" otherwise, separated by newline.

Sample Input 0

5
11
92 10 963 5 334 928 973 2 9 263 860 
9
156 153 6947 149 154 1761 7230 9 152 
4
40 49 87 651 
5
449 792 594 688 618 
15
736 43 882 3 460 741 887 0 42 247 465 739 844 886 888 
Sample Output 0

False
True
False
False
True
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
            int[] completeBT = new int[n];
            for(int i=0;i<n;i++) {
                completeBT[i] = sc.nextInt();
            }
            
            TreeNode root = insertNode(completeBT,0);
           
           System.out.println(isBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE)==true ? "True" : "False"); 
        }
    }
    
    public static boolean isBST(TreeNode root,int a, int b) {
        if(root == null) {
            return true;
        }
        if(root.data <=a || root.data >=b) {
            return false;
        }
        return ((isBST(root.left,a,root.data)) && (isBST(root.right,root.data,b)));
        
    }
    
    public static TreeNode insertNode(int[] CBT, int index) {
        if(index < CBT.length) {
            TreeNode root = new TreeNode(CBT[index]);
            root.left = insertNode(CBT,2*index+1);
            root.right = insertNode(CBT,2*index+2);
            return root;
        }
        return null;
    }
}
