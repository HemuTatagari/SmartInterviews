
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
            int n = sc.nextInt();
            
            int count[] = new int[n-1];
            
            for(int i=0; i<n ;i++) {
                count[sc.nextInt()]++;
            }
            
            for(int i=0; i<count.length; i++) {
                if(count[i] == 2) {
                    System.out.print(i+" ");
                }
            }
            
            System.out.println();
        }
    }
}
