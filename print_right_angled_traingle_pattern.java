import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int case1 = 1;
        int T = sc.nextInt();
        for(int i=0; i< T; i++,case1++) {
            int n = sc.nextInt();
            System.out.println("Case #" + case1 +":");
            for(int j=1; j<=n ;j++) {
                
                for(int k=0; k<(n-j);k++) {
                    System.out.print (" "+"");
                }
                for(int k=0; k<j;k++) {
                    System.out.print ("*" + "");
                }
                System.out.println();
            }
            
        }
    }
}
