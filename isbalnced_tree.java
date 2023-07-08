/*

Given an array of unique elements, construct a Binary Search Tree and check if its balanced. A tree is said to be balanced if for every node, the difference between the height of its child nodes is not greater than 1.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print "Yes" if the Binary Search Tree is balanced, "No" otherwise, separated by newline.

Sample Input 0

3
5
1 2 3 4 5 
5
3 2 4 1 5 
7
4 5 15 0 1 7 17 
Sample Output 0

No
Yes
No
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
            boolean flag = isBalancedTree(root);
            if(flag == true) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
    
    public static boolean isBalancedTree(TreeNode root) {
        if(root==null) {
            return true;
        }
        int leftt = findHeight(root.left);
        int rightt = findHeight(root.right);
        
        if(Math.abs(leftt - rightt) <= 1) {
            return isBalancedTree(root.left) && isBalancedTree(root.right);
        }
        return false;
        
    }
    
    public static int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left),findHeight(root.right))+1;
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
