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
            int res = 0;
            while(n != 0) {
                res+= (n & 1);
                n = n>>1;
            }
            
            System.out.println(res);
        }
    }
}
