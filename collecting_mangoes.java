/*

One day after storm Mina went to pick up mangoes in the garden with a basket. She began to pick up mangoes from the garden. And if she wants, she can throw away the last picked up mango from the basket. In this way, Mina kept picking up mangoes. She brought you with her to keep track of the biggest size of mango in the basket at that time. At any moment Mina can ask you about the biggest size of mango. Your job is to help Mina.

Since you are a good programmer, so you write a program by which you are easily able to answer the question of Mina. During picking up mangoes, Mina can have 3 types of question/instruction for you.

Type 1: Put an "x" size mango in the basket, which is picked up form garden.

Type 2: Throw out last picked up mango.

Type 3: Ask for the biggest mango size in the basket at that moment.

Input Format

First line of input contains T - number of test cases. Each case start with a positive integer N, which is number of question/operation Mina will ask during picking up mangoes. Next N lines will contain 3 types of operations (A, R, Q): A x (here x is picked up mango size), R (Throw out last picked up mango from basket), Q (Find out the biggest size mango). Please use fast IO due to large size of input/ouptut.

Constraints

30 points
1 <= T <= 100
1 <= N <= 1000
1 <= x <= 100000

70 points
1 <= T <= 100
1 <= N <= 100000
1 <= x <= 100000

Output Format

For each test case, first print the case number and print the answer to each of Mina's questions (Queries of Type 3 - Q). Whenever the basket is empty, then Mina's question's answer will be "Empty".

Sample Input 0

2
7
A 10
A 5
Q
A 100
Q
R
Q
6
A 5
Q
R
Q
R
R
Sample Output 0

Case 1:
10
100
10
Case 2:
5
Empty
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i=1;i<=T;i++) {
            System.out.println("Case "+i+":");
            
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] maxx = new int[n];
            int top = -1;
            while(n-- > 0) {
                char c = sc.next().charAt(0);
                if(c == 'A') {
                    int x = sc.nextInt();
                    if(top!=-1 && x>maxx[top]) {
                       maxx[top+1] = x; 
                    }
                    else if(top!=-1) {
                        maxx[top+1] = maxx[top];
                    }
                    else {
                        maxx[top+1] = x;
                    }
                    arr[++top] = x;
                    
                }
                
                if(c=='Q') {
                    if(top != -1) {
                    System.out.println(maxx[top]);
                    }
                    else {
                        System.out.println("Empty");
                    }
                }
                
                if(c=='R'){
                    if(top != -1) {
                        top--;
                    }
                }
                //sc.nextLine();
                
                
            }
        }
    }
}
