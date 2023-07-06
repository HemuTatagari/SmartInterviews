// using recurrsion

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
            System.out.println((1<<n) -1);
            TOH(n,'A','C','B');
        }
        
    }
    
    public static void TOH(int n, char src, char ds, char tmp) {
        if(n == 0) {
            return;
        }
        
        TOH(n-1, src,tmp, ds);
        System.out.println("Move "+n+" from " + src +" to " + ds+"");
        TOH(n-1, tmp,ds,src);
    }
}
