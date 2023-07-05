import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int cases = 1;
        int T = sc.nextInt();
        while(T > 0) {
            int n = sc.nextInt();
            System.out.println("Case #" + cases + ":");
            
            int k = n/2;
            
            // first line
            //System.out.print (" "* k);
            for(int j=0; j<k;j++) {
                System.out.print(" "+"");
            }
            System.out.print ("*" + "\n");
            
            //next half lines
            for(int i=1; i<=n/2; i++) {
                //System.out.print(" " * k-1 );
                for(int j=0; j<k-i;j++) {
                    System.out.print(" "+"");
                }
                System.out.print("*"+"");
                
                for(int j=0; j<(2*(i)-1);j++) {
                    System.out.print(" "+"");
                }
                
                System.out.print ("*" + "\n");
            }
            
            //next half lines
            for(int i=1; i<n/2; i++) {
                //System.out.print(" " * i );
                for(int j=0; j<i;j++) {
                    System.out.print(" "+"");
                }
                
                System.out.print ("*" + "");
                for(int j=0; j<(n-2*(i+1));j++) {
                    System.out.print(" "+"");
                }
                
                System.out.print ("*" + "\n");
            }
            
            //last line
            //System.out.print (" "* k);
            for(int j=0; j<k;j++) {
                System.out.print(" "+"");
            }
            System.out.print ("*" + "\n");
            
            cases++;
            T--;
            
        }
    }
}
