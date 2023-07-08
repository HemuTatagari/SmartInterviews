/*

Given an array of unique elements, construct a Binary Search Tree and print the top-view of the tree. Top view of a Tree is the set of nodes visible when tree is viewed from top.

Input Format

Given an array of unique elements, construct a Binary Search Tree and print the top-view of the tree. Top view of a Tree is the set of nodes visible when tree is viewed from top.

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the top-view of the Binary Search Tree, separate by newline. Print the set of visible nodes from left to right.

Sample Input 0

3
6
10 20 13 3 17 18 
6
10 3 20 15 14 12 
7
10 3 8 20 7 6 4 
Sample Output 0

3 10 20 18 
12 3 10 20 
4 6 3 10 20 
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
           
            HashMap<Integer,Integer> map = new HashMap<>();
            int[] min_max_arr = new int[2];
            min_max_arr[0] = Integer.MAX_VALUE;
            min_max_arr[1] = Integer.MIN_VALUE;
            int[] depth_arr = new int[10000];
            createHashMap(root,map,0,min_max_arr,depth_arr,0);
            
            int i = min_max_arr[0];
            while(i<=min_max_arr[1]) {
                System.out.print (map.get(i)+" ");
                i++;
            }
            System.out.println();
            
        }
    }
    
    public static void createHashMap(TreeNode root, HashMap<Integer,Integer> map, int v,int[] min_max_arr,int[] depth_arr,int curr_depth) {
        if(root == null) {
            return;
        }
        min_max_arr[0] = Math.min(min_max_arr[0],v);
        min_max_arr[1] = Math.max(min_max_arr[1],v);
        
        depth_arr[root.data] = curr_depth;
        if(map.containsKey(v)) {
            if(depth_arr[map.get(v)] > curr_depth) {
                map.put(v,root.data);
            }
        }
        else {
            map.put(v,root.data);
        }
        createHashMap(root.left,map,v-1,min_max_arr,depth_arr,curr_depth+1);
        createHashMap(root.right,map,v+1,min_max_arr,depth_arr,curr_depth+1);
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
