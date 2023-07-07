/*
Understand the problem statement from the given sample input and output.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains 2 strings A and B, separated by space, consisting only of lowercase English alphabets.

Constraints

10 points
1 <= T <= 100
1 <= len(A), len(B) <= 100

40 points
1 <= T <= 1000
1 <= len(A) <= 5000
1 <= len(A), len(B) <= 5000

Output Format

For each test case, print the desired output, separated by newline.

Sample Input 0

2
data structures
smart interviews
Sample Output 0

srucures
ineview
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
                String first = in.next();
                String second = in.next();
                
                int[] arr = new int[26];
                for(int i=0;i<first.length();i++) {
                    arr[(int)first.charAt(i) - 97]++;
                }
                
                for(int i=0;i<second.length();i++) {
                    if(arr[(int)second.charAt(i)-97] == 0) {
                        out.print(second.charAt(i)+"");
                    }
                }
                
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
