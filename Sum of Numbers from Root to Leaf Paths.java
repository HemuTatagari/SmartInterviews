/*

Given an array of unique elements, construct a Binary Search Tree and print the sum of all the numbers formed along the path from the root node to the leaf nodes.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Constraints

1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Output Format

For each test case, print the sum, separate each traversal by newline. Since the output can be very large, print output % 1000000007.

Sample Input 0

3
5
1 2 3 4 5
5
3 2 4 1 5
7
4 5 15 2 1 7 17
Sample Output 0

12345
666
497095
Explanation 0

Test Case 1
Total Sum = 12345

Test Case 2
Total Sum = 321 + 345 = 666

Test Case 3
Total Sum = 421 + 45157 + 451517 = 497095

*/


import java.io.*;
import java.util.*;

public class Solution {
    static int k = 1000000007;
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
            System.out.println(getTreeSum(root,0L)%k);
        }
    }
    
    public static long getTreeSum(TreeNode root,long curr_sum) {
        if(root == null) {
            return 0;
        }
        
        int temp = root.data;
        int digitCount = 0;
        
        if(temp == 0) {
            digitCount++;
        }
        while(temp>0) {
            digitCount++;
            temp/=10;
        }
        curr_sum = (((curr_sum)*((int)Math.pow(10,digitCount)%k)%k) + root.data)%k;
        
        if(root.left == null && root.right == null) {
            return curr_sum%k;
        }
        return ((getTreeSum(root.left, curr_sum)%k + getTreeSum(root.right,curr_sum)%k)%k);
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
