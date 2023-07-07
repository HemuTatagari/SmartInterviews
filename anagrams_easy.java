/*

Given 2 strings, check if they are anagrams. An anagram is a rearrangement of the letters of one word to form another word. In other words, some permutation of string A must be same as string B.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing 2 space separated strings.

Constraints

10 points
1 <= T <= 100
1 <= len(S) <= 103
'a' <= S[i] <= 'z'

40 points
1 <= T <= 100
1 <= len(S) <= 105
'a' <= S[i] <= 'z'

Output Format

For each test case, print True/False, separated by newline.

Sample Input 0

4
a a
b h
stop post
hi hey
Sample Output 0

True
False
True
False
Explanation 0

Self Explanatory
  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- >0){
            String s1=sc.next();
            String s2=sc.next();
            if(s1.length()==(s2.length())){
                char[] a=s1.toCharArray();
                char[] b=s2.toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                int cnt=0;
                for(int i=0;i<s1.length();i++){
                    if(a[i]==b[i]){
                        cnt=cnt+1;
                    }
                    else{
                        System.out.println("False");
                        break;
                    }
                }
                if(cnt==s1.length()){
                    System.out.println("True");
                }
            }
            else{
                System.out.println("False");
            }
            
            
        }
    }
}
