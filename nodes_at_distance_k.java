/*

Given an array of unique elements, construct a Binary Search Tree and find the number of nodes at a distance K from the given source node S. Distance is defined as the number of edges between 2 nodes.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N, S, K - number of nodes in the BST, the source node and the distance K. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the number of nodes in the Binary Search Tree which are K distance away from S, separated by newline.

Sample Input 0

3
5 3 2
1 2 3 4 5 
5 4 1
2 4 3 1 5 
7 5 2
4 5 15 0 1 7 17 
Sample Output 0

2
3
3
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
            int src = sc.nextInt();
            int k = sc.nextInt();
            TreeNode root = null;
            for(int i=0;i<n;i++) {
                root = insertNode(root,sc.nextInt());
            }
           
            ArrayList<TreeNode> path = new ArrayList<>();
            findPath(root,src,path);
            
            int ans = countNodes(path.get(0),k);
            for(int i=1;i<path.size();i++) {
                if(i == k) {
                    ans+=1;
                    break;
                }
                if(path.get(i).left == path.get(i-1)) {
                    ans+= countNodes(path.get(i).right,k-i-1);
                }
                else {
                    ans+= countNodes(path.get(i).left,k-i-1);
                }
            }
            System.out.println(ans);
        }
    }
    
    public static boolean findPath(TreeNode root,int src,ArrayList<TreeNode> path) {
        if(root == null) {
            return false;
        }
        
        if(root.data == src || findPath(root.right,src,path) == true || findPath(root.left,src,path) == true ) {
            path.add(root);
            return true;
        } 
        return false;
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
    
    public static int countNodes(TreeNode root,int k) {
        if(root == null) {
            return 0;
        }
        if(k==0) {
            return 1;
        }
        
        return countNodes(root.left,k-1) + countNodes(root.right,k-1);
    }
}
