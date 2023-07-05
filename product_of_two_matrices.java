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
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            
            int mat1[][] = new int[r1][c1];
            for(int i=0; i<r1;i++) {
                for(int j=0; j<c1; j++) {
                    mat1[i][j] = sc.nextInt();
                }
            }
            
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            
            int mat2[][] = new int[r2][c2];
            for(int i=0; i<r2;i++) {
                for(int j=0; j<c2; j++) {
                    mat2[i][j] = sc.nextInt();
                }
            }
            
            int res[][] = new int[r1][c2];
            
            for(int i=0; i<r1; i++) {
                for(int j=0; j<c2; j++) {
                    
                    for(int k=0; k<r2; k++) {
                        res[i][j] += mat1[i][k] *mat2[k][j];
                    }
                }
            }
            
            printMat(res, r1, c2);
            T--;
            
        }
    }
    
    public static void printMat(int[][] res, int r, int c) {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print (res[i][j] + " ");
            }
            
            System.out.println();
        }
    }
}
