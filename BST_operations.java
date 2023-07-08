/*


You are given Q queries. Each query can be one of four types:
1 X: Insert an integer X into the binary search tree.
2 X: Delete X from the tree.
(If the node has both child present, replace it with the smallest value from its right sub-tree)
3 X: Print "Yes" if the value exists in the binary search tree, print "No" otherwise.
4: Print the Preorder traversal of the binary search tree.
Input Format

First line of input contains T - number of test cases.
The second line contains Q - the number of queries.
The Q subsequent lines each contain 2 integers A - the type of query and X - the value to be processed in the query (except for query of type 4).

Constraints

1 <= T <= 100
1 <= Q <= 100
1 <= A <= 4
-105 <= X <= 105

Output Format

For each test case, print the result, separated by newline. If no such result exists, print "null".

Sample Input 0

2
8
1 4
1 2
1 6
1 8
2 2
3 3
4
3 1
7
1 5
1 7
1 3
4
3 3
2 3
3 3
Sample Output 0

Case #1:
No
4 6 8
No
Case #2:
5 3 7
Yes
No
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
        int cases = 1;
        while(cases <= T) {
            System.out.println("Case #"+cases+":");
            TreeNode root = null;
            int q = sc.nextInt();
            while(q-- > 0) {
                int optn = sc.nextInt();
                switch(optn) {
                    case 1 :
                        root = insertNode(root,sc.nextInt());
                        break;
                    case 2 :
                        root = deleteNode(root,sc.nextInt());
                        break;
                    case 3 :
                        System.out.println(findNode(root, sc.nextInt()));
                        break;
                    case 4 :
                        preOrder(root);
                        System.out.println();
                        break;
                    default :
                        int x = 4; // just like that
                        
                }
            }
            cases++;
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
    
    public static String findNode(TreeNode root, int ele) {
        if(root == null) {
            return "No";
        }
        if(root.data == ele) {
            return "Yes";
        }
        else if(root.data < ele) {
            return findNode(root.right,ele);
        }
        return findNode(root.left,ele);
    }
    
    public static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        System.out.print (root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static TreeNode deleteNode(TreeNode root, int ele) {
        if(root == null) {
            return null;
        }
        if(root.data < ele) {
            root.right = deleteNode(root.right,ele);
        }
        else if(root.data > ele) {
            root.left = deleteNode(root.left,ele);
        }
        else {
            if(root.left == null && root.right == null) {
                return null;
            }
            else if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                root.data = getMin(root.right).data;
                root.right = deleteNode(root.right,root.data);
            }
        }
        return root;
    }
    
    public static TreeNode getMin(TreeNode root) {
        if(root.left == null) {
            return root;
        }
        return getMin(root.left);
    }
}
