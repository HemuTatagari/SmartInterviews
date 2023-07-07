/*

Given a string without duplicates, find its rank (position) in all the permutations of the string when sorted lexicographically.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains a single string consisting of only lowercase English alphabets.

Constraints

30 points
1 <= T <= 100
1 <= len(str) <= 10

70 points
1 <= T <= 1000
1 <= len(str) <= 20

Output Format

For each test case, print the rank of the given string, separated by newline.

Sample Input 0

3
cba
smart
algorithms
Sample Output 0

6
79
123523
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
    
    public static long fact(long n) {
        return (n<=1) ? 1 : n*fact(n-1);
    }
    
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            
            while(testCases-- > 0){
                // write code here
                String str = in.nextLine();
                int n = str.length();
                
                long[] count = new long[256];
                for(int i=0;i<n;i++) {
                    count[(int)str.charAt(i)]++;
                }
                
                for(int i=1;i<256;i++) {
                    count[i]+=count[i-1];
                }
                
                long rank = 1;
                long temp = n-1;
                for(int i=0;i<n;i++,temp--) {
                    

                    rank += count[(int)str.charAt(i)-1] * fact(temp);
                    
                    for(int j= str.charAt(i); j<256;j++) {
                        count[j]--;
                    }
                }
                
                System.out.println(rank);
              
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
