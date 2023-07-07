/*

Understand the problem statement from the given sample input and output.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a string consisting only of lowercase English alphabets and an integer K.

Constraints

1 <= T <= 1000
1 <= len(str) <= 1000
0 <= k <= 100000

Output Format

For each test case, print the desired output, separated by newline.

Sample Input 0

2
smart 3
interviews 10
Sample Output 0

vpduw
sxdobfsogc
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
                String str = in.next();
                int k = in.nextInt();
                char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                for(int i=0;i<str.length();i++) {
                    out.print(arr[((int)str.charAt(i)-97 + k)%26]);
                }
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
