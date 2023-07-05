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
            long n = sc.nextLong();
            long res = 0;
            for(long i=5; n/i >= 1; i=i*5){
                res += n/i;
            }
            System.out.println(res);
            T--;
        }
    }
}
