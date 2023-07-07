/*

Two people are playing a game of numbers! The rules of the game are:

The game is played on a given number N.
The players take turns one by one. During each move, the current player can subtract a number p from N, where p is a prime number p<=N.
The game ends when a player cannot make a move. The first player to have no available move loses the game.
Given the value of N, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single integer N.

Constraints

30 points
1 <= T <= 100
1 <= N <= 100

70 points
1 <= T <= 104
1 <= N <= 104

Output Format

For each test case, print the name of the winner, separated by newline.

Sample Input 0

4
10
5
3
25
Sample Output 0

Second
First
First
Second
Explanation 0

Self Explanatory

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ArrayList<Integer> primes = new ArrayList<>();
        
        int flag[] = new int[10001];
        for(int i=2;i<=Math.sqrt(10000);i++) {
            if(flag[i] == 1) {
                continue;
            }
            
            int j=i*i;
            while(j<=10000) {
                flag[j] = 1;
                j+=i;
            }
        }
        
        for(int i=2;i<=10000;i++) {
            if(flag[i]==0) {
                primes.add(i);
            }
        }
        
        //System.out.println(primes);
        
        String[] ref = new String[10001];
        ref[0] = "Second";
        
        for(int i=1;i<=10000;i++) {
            int j=0;
            boolean flaggg = true;
            while(j<primes.size() && primes.get(j)<=i) {
                if(ref[i-primes.get(j)]=="Second") {
                    flaggg = false;
                    ref[i] = "First";
                    break;
                }
                j++;
            }
            if(flaggg) {
                ref[i] = "Second";
            }
        }
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            System.out.println(ref[sc.nextInt()]);    
        }
        
    }
}
