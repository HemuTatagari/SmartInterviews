/*
You are given an array of N elements. All elements of the array are in range 1 to N-2. All elements occur once except two numbers, which occur twice. Your task is to find the two repeating numbers.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and second line contains the elements of the array.

Constraints

30 points
1 <= T <= 100
4 <= N <= 103

70 points
1 <= T <= 100
4 <= N <= 106

Output Format

Print the 2 repeated numbers in sorted manner, for each test case, separated by new line.

Sample Input 0

2
8
1 3 2 3 4 6 5 5 
10
1 5 2 8 1 4 7 4 3 6 
Sample Output 0

3 5
1 4
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
        while(T-- > 0) {
            int n = sc.nextInt();
            
            int count[] = new int[n-1];
            
            for(int i=0; i<n ;i++) {
                count[sc.nextInt()]++;
            }
            
            for(int i=0; i<count.length; i++) {
                if(count[i] == 2) {
                    System.out.print(i+" ");
                }
            }
            
            System.out.println();
        }
    }
}
