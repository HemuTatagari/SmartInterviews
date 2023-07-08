/*

Consider an array of 0's of size N. You are given Q queries of the following types:

1 idx: Toggle the element present at the given index. If the element is 0, make it 1 and vice versa.
2 idx: Print the distance of the nearest 1 from the given index.
Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array and Q - the number of queries, separated by a space.
The Q subsequent lines contain two integers K - the type of the query and i - an index in the array.

Constraints

30 points
1 <= N <= 103
1 <= Q <= 1000

70 points
1 <= N <= 109
1 <= Q <= 5x104

General Constraints
1 <= T <= 100
K ∈ [1,2]

Output Format

For each test case, process the queries and for each query of type 2, print the result separated by a newline.
For queries of type 2, if such an element is not found, print -1.

Sample Input 0

2
5 4
1 1
2 0
1 3
2 4
6 4
2 0
1 0
1 5
2 2
Sample Output 0

1
1
-1
2
Explanation 0

Test Case 1

Initially the array is: 0 0 0 0 0

First query: 1 1
Toggle the element at index 1. The resulting array is: 0 1 0 0 0

Second query: 2 0
Print the distance to the nearest 1 from index 0. Since the nearest 1 is present at index 1, the distance is 1.

Third query: 1 3
Toggle the element at index 3. The resulting array is: 0 1 0 1 0

Fourth query: 2 4
Print the distance to the nearest 1 from index 4. Since the nearest 1 is present at index 3, the distance is 1.

  */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            long n = sc.nextInt();
            long q = sc.nextInt();
            
            //logic
            ArrayList<Long> al = new ArrayList<>();
            HashMap<Long,Integer> map = new HashMap<>();
            while(q-- > 0) {
                int type = sc.nextInt();
                long idx = sc.nextInt();
                
                if(type == 1) {
                    toggle(idx,al,map);
                }
                else {
                    //type 2
                    if(al.size() == 0) {
                        System.out.println(-1);
                    }
                    else {
 
                        long floor = findFloor(al,idx);
                        long ceil = findCeil(al,idx);
                        //System.out.println(al+" "+floor+" "+ceil);
                        if(ceil==-1) {
                            System.out.println(idx-floor);
                        }
                        else if(floor  == -1) {
                            System.out.println(ceil-idx);
                        }
                        else {
                            System.out.println(Math.min(idx-floor,ceil-idx));
                        }
                    }
                }
            }
        }
    }
    
    public static void toggle(long idx,ArrayList<Long> al,HashMap<Long,Integer> map) {
        if(map.containsKey(idx)) {
            al.remove(idx); 
            map.remove(idx);
        }
        else {
            al.add(idx);
            map.put(idx,1);
        }
        
        return;
    }
    
    public static long findFloor(ArrayList<Long> al, long key){
        Collections.sort(al);
        int low = 0, high = al.size()-1;
        long floor = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            long ele = al.get(mid);
            if(ele == key) {
                return ele;
            }
            else if(ele<key) {
                floor = ele;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        
        return floor;
    }
    
    public static long findCeil(ArrayList<Long> al, long key){
        Collections.sort(al);
        int low = 0, high = al.size()-1;
        long ceil = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            long ele = al.get(mid);
            if(ele == key) {
                return ele;
            }
            else if(ele>key) {
                ceil = ele;
                high =mid-1;
            }
            else {
                low=mid+1;
            }
        }
        
        return ceil;
    }
}
