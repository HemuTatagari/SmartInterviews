
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i< T; i++) {
            int n = sc.nextInt();
            long sum = 0;
            for(int j=0; j<n;j++) {
                sum = sum + (sc.nextLong());
            }
            
            System.out.println(sum);
        }
    }
}
