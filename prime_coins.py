/*

Santa and Banta are playing a game of coins. They have a pile containing N coins. Players take alternate turns, removing some coins from the pile. On each turn, a player can remove either one coin or coins equal to some prime power (i.e. px coins, where p - prime number and x - positive integer). Game ends when the pile becomes empty. The player who can not make a move in his turn loses.

Given the pile size, and assuming Santa always plays the first move, your task is to find out who will win the game, provided that both the players play optimally.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single integer N - pile size.

Constraints

1 <= T <= 10000
1 <= N <= 109

Output Format

For each test case, print the name of the winner, separated by newline.

Sample Input 0

4
1
6
4
9
Sample Output 0

Santa
Banta
Santa
Santa
Explanation 0

Self Explanatory

  */

for i in range(int(input())) :
    n = int(input())
    if(n%6 == 0) :
        print("Banta")
    else :
        print("Santa")
