/*

Given an array of unique elements, construct a Binary Search Tree and print the Level Order of the tree, not top-down, but bottom-up.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the bottom-up Level Order of the Binary Search Tree, separate each level by newline. Separate the output of different test cases with an extra newline.

Sample Input 0

3
5
1 2 3 4 5 
5
3 2 4 1 5 
7
4 5 15 0 1 7 17 
Sample Output 0

5 
4 
3 
2 
1 

1 5 
2 4 
3 

7 17 
1 15 
0 5 
4 
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
            printLevelOrder(root);
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
    
    public static void printLevelOrder(TreeNode root) {
        int size = 0;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while(q.size()!=0) {
            level++;
            ArrayList<Integer> al = new ArrayList<>();
            size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.remove();
                if(curr.left!=null) {
                    q.add(curr.left);
                }
                if(curr.right!=null) {
                    q.add(curr.right);
                }
                //System.out.print(curr.data+" ");
                al.add(curr.data);
            }
            map.put(level,al);
            
        }
        while(level > 0) {
            for(int i=0;i<map.get(level).size();i++) {
                System.out.print (map.get(level).get(i)+" ");
            }
            System.out.println();
            level--;
        }
    }
}
