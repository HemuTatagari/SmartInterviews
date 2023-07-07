/*

Given 2 strings A and B, find the smallest substring of B having all the characters of A, in any order.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line containing 2 space separated strings - A and B.

Constraints

20 points
1 <= T <= 100
1 <= size(A), size(B) <= 100

60 points
1 <= T <= 100
1 <= size(A), size(B) <= 1000

120 points
1 <= T <= 100
1 <= size(A), size(B) <= 10000

General Constraints
'a' <= A[i],B[i] <= 'z'

Output Format

For each test case, print the length of the smallest substring of B having all the characters of A, separated by newline. If no such substring found, print -1.

Sample Input 0

4
fkqyu frqkzkruqmfqyuzlkyg
onmwvytbytn uqhmfjaqtgngcwkuzyamnerphfmw
bloets lwbcrsfothplxseplrtbshbtstjloxsf
dzpd dclzztpjldkndgbdqqzmbp
Sample Output 0

7
-1
13
9
Explanation 0

Self Explanatory

  */

// note :- Fast I/O template used

import java.util.*;
import java.io.*;

public class Main{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                // write code here
                
                String b = in.next();
                String a = in.next();
                
                int n = a.length();
                int m = b.length();
                
                int count_b[] = new int[26];
                
                for(int i=0;i<m;i++) {
                    count_b[(int)b.charAt(i)-97]++;
                }
                
                int low = m, high = n;
                //System.out.println(low+""+high);
                int ans = Integer.MAX_VALUE;
                while(low<=high) {
                    int flag = 0;
                    int count_a[] = new int[26];
                    int mid = (low+high)/2;
                    //System.out.println("Mid"+mid);
                    for(int i=0;i<mid;i++) {
                        count_a[(int)a.charAt(i)-97]++;
                        if(isValid(count_a,count_b)) {
                            flag = 1;
                            
                        }
                    }
                    for(int i=1;i<=n-mid;i++) {
                        count_a[(int)a.charAt(i-1)-97]--;
                        count_a[(int)a.charAt(i+mid-1)-97]++;
                        
                        if(isValid(count_a,count_b)) {
                            flag = 1;
                            //System.out.println("came2");
                        }
                        //System.out.println("came2");
                    }
                    
                    if(flag == 1) {
                        ans = Math.min(ans,mid);
                        high = mid - 1;
                        
                    }
                    else {
                        low = mid+1;
                    }
                }
                if(ans == Integer.MAX_VALUE) {
                    System.out.println(-1);
                }
                else {
                System.out.println(ans);
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    
    public static boolean isValid(int[] count_a,int[] count_b) {
        //System.out.println("came");
        for(int i=0;i<26;i++) {
            if(count_a[i] < count_b[i]){
                return false;
            }
        }
        
        return true;
    }
}
