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
        int n, cases = 1;
        int arr[][];
        while(T > 0) {
            n = sc.nextInt();
            arr = new int[n][n]; 
            
            for(int i=0; i<n;i++) {
                for(int j=0; j<n;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            //solution
            System.out.println("Test Case #"+cases+":");
            for(int i = 0; i< n;i++) {
                for(int j=n-1; j >= 0; j--) {
                    System.out.print (arr[j][i] + " ");
                }
                System.out.println();
            }
            cases ++;
            T--;
        }
        
    }
}
