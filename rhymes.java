/*

Given is a wordlist L, and a word w. Your task is to find the length of the longest word in L having the longest common suffix with w.

Input Format

First line of input contains N - length of the list of words. The next N lines contains a single word having lowercase english alphabets. The next line contains Q - number of queries. Each of the next Q lines contains a single word w having lowercase english alphabets.

Constraints

50 points
1 <= N, Q <= 1000
1 <= len(word) <= 100

150 points
1 <= N, Q <= 10000
1 <= len(word) <= 500

Output Format

For each query w, print the length of the longest word having the longest common suffix with w, separated by newline.

Sample Input 0

4
crime
fast
time
cast
3
dime
gist
algorithm
Sample Output 0

5
4
0
Explanation 0

Test Case 1
Both the words crime and time have the longest common suffix with dime. Hence, length of the longest word is 5.

Test Case 2
Both the words fast and cast have the longest common suffix with gist. Hence, length of the longest word is 4.

Test Case 3
There is no word in L having a common suffix with algorithm. Hence, length of the longest word is 0.

  */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class Trie
{
    Trie[] child;
    int l_count;
    Trie()
    {
         child=new Trie[26];
        for(int i=0;i<26;i++)
        {
            child[i]=null;
        }
      l_count=0;
    }
}
public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        Trie root=new Trie();
        Trie st_root=root;
        for(int i=0;i<n;i++)
        {
            root=st_root;
            String s=sc.next();
            
            for(int c=s.length()-1;c>=0;c--)
            {
                int char_ascii=(int)(s.charAt(c)-97);
                if(root.child[char_ascii]==null)
                {
                    root.child[char_ascii]=new Trie();
                }
                        
                root.child[char_ascii].l_count=root.l_count+1;
                root=root.child[char_ascii];
               // System.out.println("char"+s.charAt(c)+"count"+root.l_count);
                 
            }
        }
        //
        int q=sc.nextInt();
         while(q-->0)
         {
             String s=sc.next();
             System.out.println(search(s,st_root));
         }
        
        
        
    }
    public static int search(String s,Trie root)
    {
        for(int i=s.length()-1;i>=0;i--)
        {
            int ascii=(int)(s.charAt(i)-97);
            if(root.child[ascii]==null)
            {
                if(i==s.length()-1) {
                    return 0;
                }
                // return 0;
                return max_children(root);
            }
            root=root.child[ascii];
        }
        return max_children(root);
    }
    public static int max_children(Trie root)
    {
        int max=0;
        //Trie last_child=root;
        for(int i=0;i<26;i++)
        {
            if(root.child[i]!=null)
            {
               max= Math.max(max_children(root.child[i]),max);
                //last_child=root.child[i];
            }
        }
        if(max==0)
        {
          //return last_child.l_count;
            return root.l_count;
        }
        return max;
        
    }
}
