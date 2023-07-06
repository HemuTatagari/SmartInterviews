import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(T-- > 0) {
            long n = sc.nextLong();
            long res =  0;
            long x = 0;
            while(n != 0) {
                long prev = (n&1);
                n = n>>1;
                
                long next = (n&1);
                n=n>>1;
                if(next != 0) {
                    res+=(1<<(x));
                }
                if(prev != 0) {
                    res += (1<<(x+1));
                }
                    
                x+=2;
            }
            
            System.out.println(res);
        }
    }
}
