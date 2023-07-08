/*

Given an array of positive integers, find 2 elements such that their xor: a ^ b is maximum.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines - the first line contains N: the size of the array. The second line contains N integers - the elements of the array.

Constraints

50 points
1 <= T <= 100
2 <= N <= 103
0 <= A[i] <= 106

150 points
1 <= T <= 100
2 <= N <= 105
0 <= A[i] <= 106

Output Format

For each test case, print the value of the maximum xor, separated by new line.

Sample Input 0

2
3
12 15 9 
5
13 11 35 3 32 
Sample Output 0

6
46
Explanation 0

Test Case 1
You can form the following xor pairs:
12^15 = 3, 12^9 = 5, 15^9 = 6 : max = 6

  */


import java.io.*;
import java.util.*;


class Trie
{
    Trie[] children=new Trie[2];
    Trie()
    {
       children[0]=null;
        children[1]=null;
        
    }
    
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
                int[] arr=new int[n];
                int max=-1;
                for(int i=0;i<n;i++)
                {
                   arr[i]=sc.nextInt();
                   max=Math.max(arr[i],max);
                }
                int bits=(int)(Math.log(max) / Math.log(2));
                Trie root=new Trie();
                for(int i=0;i<n;i++)
                {
                    Insert(bits,root,arr[i]);
                }
                int xor_max=-1;
                for(int i=0;i<n;i++)
                {
                 xor_max=Math.max(xor_max,MaxXorPair(bits, root,arr[i]));   
                }
                System.out.println(xor_max);
                
            
        }
        
    }

    public static void Insert(int bits, Trie root,int x)
    {
        for(int i=bits;i>=0;i--)
        {
            int digit=-1;
            if(((x>>i)&1)==0)
            {
                digit=0;
            }
            else
            {
                digit=1;
            }
            if(root.children[digit]==null)
            {
                root.children[digit]=new Trie();
            }
            root=root.children[digit];
        }
    }
    public static int MaxXorPair(int bits,Trie root,int x)
    {
        int sum=0;
        int val=-1;
        for(int i=bits;i>=0;i--)
        {
            if(((x>>i) &1)==0)
            {
                val=0;
            }
            else{
                val=1;
            }
            if(root.children[1-val]!=null)
            {
                sum=sum+(1<<i);
                root = root.children[1-val];
            }
            else {
                root=root.children[val];
            }
        }
        return sum;
    }
}
