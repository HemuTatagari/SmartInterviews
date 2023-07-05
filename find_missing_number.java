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
            int arr[] = new int[n];
            int temp[] = new int[n+2];
            for(int i=0; i< n; i++) {
                arr[i] = sc.nextInt();
                temp[arr[i]]++;
            }
            
            for(int i=1; i<=n+1; i++) {
                if(temp[i] == 0) {
                    System.out.println(i);
                    break;
                }
            }
            
            
        }
    }
}
