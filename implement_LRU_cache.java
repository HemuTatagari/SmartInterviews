/*

Design and implement a data structure for Least Recently Used (LRU) cache. Given a list of page numbers, insert them in a cache of size K in an LRU fashion. This simply means that when the cache is full and a new entry comes, you need to replace the Least Recently Used entry in the cache with the new entry.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N and K - number of pages and the cache size. Second each contains a list of N page numbers separated by space.

Constraints

1 <= p[i] <= 100000
1 <= T <= 1000

50 points
1 <= N,K <= 100

150 points
1 <= N,K <= 5000

Output Format

For each test case, print the final contents of the cache in a LRU fashion, separated by newline.

Sample Input 0

3
5 3
3 8 2 8 1 
8 5
4 7 3 10 7 8 5 3 
10 5
6 5 6 2 3 14 2 1 10 10 
Sample Output 0

2 8 1 
10 7 8 5 3 
3 14 2 1 10 
Explanation 0

Self Explanatory

  */

import java.io.*;
import java.util.*;

public class Solution {
    
    public static class ListNode {
        int data;
        ListNode next;
        ListNode prev;
        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            HashMap<Integer,ListNode> map = new HashMap<>();
            ListNode head = new ListNode(-1), track = head;
            while(n-- > 0) {
                int ele = sc.nextInt();
                ListNode newNode = new ListNode(ele);
                if(map.containsKey(ele)) {
                    if(map.get(ele).next != null) {
                        map.get(ele).next.prev = map.get(ele).prev;
                    }
                    else {
                        track = map.get(ele).prev;
                    }
                    map.get(ele).prev.next = map.get(ele).next;
                    map.remove(ele);
                }
                else {
                    if(map.size() == k) {
                        if(head.next.next!=null) {
                            head.next.next.prev = head;
                        }
                        else {
                            track = head;
                        }
                        map.remove(head.next.data);
                        head.next = head.next.next;
                    }
                }
                map.put(ele,newNode);
                track.next = newNode;
                newNode.prev = track;
                track = newNode;
            }
            
            ListNode temp = head.next;
            while(temp!=null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            
            System.out.println();
            
        }
    }
}
