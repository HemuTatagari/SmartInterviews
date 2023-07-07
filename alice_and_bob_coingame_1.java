/*

Alice and Bob are playing a game. The game involves N coins and in each turn a player may remove at most M coins. In each turn a player must remove atleast 1 coin. The player who takes the last coin wins the game.

Alice and Bob decide to play 3 such games while employing different strategies each time. In the first game, both Alice and Bob play optimally. In the second game, Alice decides to play optimally but Bob decides to employ a greedy strategy, i.e, he always removes the maximum number of coins which may be removed in each turn. In the last game, both the players employ the greedy strategy. Find out who will win each game.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each of which contains an integer N - the total number of coins, M - the maximum number of coins which may be removed in each turn and a string S - the name of the player who starts the game, separated by space.

Constraints

1 <= T <= 1000
1 <= N <= 1018
1 <= M <= N

Output Format

For each test case, print the name of the person who wins each of the three games on a newline. Refer to example output for the format.

Sample Input 0

2
5 3 Bob
10 3 Alice
Sample Output 0

Test-Case #1:
G1: Bob
G2: Alice
G3: Alice

Test-Case #2:
G1: Alice
G2: Alice
G3: Bob
Explanation 0

Test-Case 1
In G1 where both employ optimal strategies: Bob will take 1 coin and no matter what Alice plays, Bob will be the one who takes the last coin.
In G2 where Alice employs an optimal strategy and Bob employs a greedy strategy: Bob will take 3 coins and Alice will remove the remaining 2 coins.
In G3 where both employ greedy strategies: Bob will take 3 coins and Alice will remove the remaining 2 coins.

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int cases = 1;
        while(cases<=T) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            
            String player1 = sc.next();
            String player2 = "";
            
            if(player1.equals("Bob")) {
                player2 = "Alice";
            }
            else {
                player2 = "Bob";
            }
            
            System.out.println("Test-Case #"+cases+":");
            //optimal v/s optimal
            if(n%(m+1) == 0) {
                System.out.println("G1: "+player2);
            }
            else {
                System.out.println("G1: "+player1);
            }
            
            //optimal v/s greedy
            if(player1.equals("Alice")) {
                //optimal
                if(n==(m+1)) {
                    System.out.println("G2: "+player2);
                }
                else {
                    System.out.println("G2: "+player1);
                }
            }
            else {
                //greedy
                if(n<=m || n==(m+m+1)) {
                    System.out.println("G2: "+player1);
                }
                else {
                    System.out.println("G2: "+player2);
                }
            }
            
            
            //greedy vs greedy
            long mod = n%(m+m);
            if(mod == 0 || mod >m) {
                System.out.println("G3: "+player2);
            }
            else {
                System.out.println("G3: "+player1);
            }
            
            cases++;
            System.out.println();
        }
    }
}
