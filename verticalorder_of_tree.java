/*

Given an array of unique elements, construct a Binary Search Tree and print the tree in a Vertical Order, starting from the left-most node. Print the nodes in each vertical in sorted order.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the Vertical Levels of the Binary Search Tree, separate each level by newline. Separate the output of different test cases with an extra newline.

Sample Input 0

3
5
1 2 3 4 5 
5
3 1 2 5 4 
7
4 5 15 0 1 7 17 
Sample Output 0

1 
2 
3 
4 
5 

1 
2 3 4 
5 

0 
1 4 
5 7 
15 
17 

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
           
            HashMap<Integer,SortedSet<Integer>> map = new HashMap<>();
            int[] min_max_arr = new int[2];
            min_max_arr[0] = Integer.MAX_VALUE;
            min_max_arr[1] = Integer.MIN_VALUE;
            createHashMap(root,map,0,min_max_arr);
            
            int i = min_max_arr[0];
            while(i<=min_max_arr[1]) {
                Iterator itr  = map.get(i).iterator();
                while(itr.hasNext()) {
                    System.out.print(itr.next()+" ");
                }
                System.out.println();
                i++;
            }
            System.out.println();
            
        }
    }
    
    public static void createHashMap(TreeNode root, HashMap<Integer,SortedSet<Integer>> map, int v,int[] min_max_arr) {
        if(root == null) {
            return;
        }
        min_max_arr[0] = Math.min(min_max_arr[0],v);
        min_max_arr[1] = Math.max(min_max_arr[1],v);
        if(map.containsKey(v)) {
            map.get(v).add(root.data);
        }
        else {
            SortedSet<Integer> al = new TreeSet<Integer>();
            al.add(root.data);
            map.put(v,al);
        }
        createHashMap(root.left,map,v-1,min_max_arr);
        createHashMap(root.right,map,v+1,min_max_arr);
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
