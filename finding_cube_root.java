
/*
Find the cube root of the given number. Assume that all the input test cases will be a perfect cube.
Note: Do not use any inbuilt functions/libraries for your main logic.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each containing a single integer.

Constraints

30 points
1 <= T <= 103
-109 <= N <= 109

70 points
1 <= T <= 106
-1018 <= N <= 1018

Output Format

For each test case, print the cube root of the number, separated by newline.

Sample Input 0

5
-27
-125
1000
6859
-19683
Sample Output 0

-3
-5
10
19
-27
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
            long n = sc.nextLong();
            System.out.println(findCubeRoot(n));
        }
    }
    
    public static long findCubeRoot(long n) {
        long k = 1, res = 0;
        if(n < 0) {
             k = -1;  
             n = n*-1;
        }
        
        long low = 0, high = 1000000,mid ;
        while(low<=high){
            mid = (low+high)/2;
            if(mid*mid*mid == n) {
                res = mid;
                break;
            }
            else if(mid*mid*mid < n) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return res * k;
    }
}
