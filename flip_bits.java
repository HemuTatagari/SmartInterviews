import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            long from = sc.nextInt();
            long to = sc.nextInt();
            
            long temp = (from ^ to);
            
            System.out.println(countBits(temp));
        }
    }
    
    public static int countBits(long n){
        int res = 0;
        while(n != 0) {
            if((n&1L) == 1) { 
                res++;
                
            }
            n = n>>1;
        }
        return res;
    }
}
