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
        while(T > 0) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            
            long t1 = a, t2 = b, t =0;
            while(t2 != 0) {
                t = t2;
                t2 = t1 % t2;
                t1 = t;
            }
            
            long gcd = t1;
            long lcm = (a * b)/t1;
            
            System.out.println(lcm + " " + gcd);
            T--;
        }
        
        
    }
}
