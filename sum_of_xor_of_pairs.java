import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n;i++) {
                arr[i] = sc.nextInt();
            }
            long res = 0;
            
            for(int i=0;i<32;i++) {
                long zc = 0, oc = 0;
                for(int j=0;j<n;j++) {
                    if(setBit(arr[j],i)){
                        oc ++;
                    }
                    else {
                        zc++;
                    }
                }
                
                res = res + (zc * oc * (1 << i));
            }
            
            System.out.println(res*2);
            
        }
        
        
    }
    
    public static boolean setBit(int n, int i) {
        if((n&(1<<i)) !=0) {
            return true;
        }
        return false;
    }
}
