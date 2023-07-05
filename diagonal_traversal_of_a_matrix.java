import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        //input
        int T = sc.nextInt();
        
        while(T > 0) {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            
            for(int i=0; i<n;i++) {
                for(int j=0; j<n;j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            
            //code
            int i=0, j=n-1;
            int sum = 0,p,q;
            while(i>=0 && j>=0) {
                p=i;
                q = j;
                sum = 0;
                while(p<n && q<n) {
                    sum+=mat[p][q];
                    p++;
                    q++;
                    
                }
                
                System.out.print(sum + " ");
                
                
                j--;
                i=0;
            }
            
            i=1;
            j=0;
            sum=0;
            while(i < n) {
                sum = 0;
                p=i;
                q=j;
                while(p<n && q<n) {
                    sum = sum + mat[p][q];
                    p++;
                    q++;
                }
                
                System.out.print (sum + " ");
                i+=1;
                j=0;
            }
            System.out.println();
            T--;
        }
        
    }
}
