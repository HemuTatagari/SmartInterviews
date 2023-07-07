/*
Given a string, find the length of the largest palindromic substring.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. The first line contains N - the size of the string and the second line contains a string of size N, containing only lowercase english alphabets.

Constraints

30 points
1 <= T <= 200
1 <= len(S) <= 102
'a' <= S[i] <= 'z'

70 points
1 <= T <= 200
1 <= len(S) <= 103
'a' <= S[i] <= 'z'

Output Format

For each test case, print the length of the largest palindromic substring, separated by newline.

Sample Input 0

5
8
pfyafafd
9
sllwffoqq
6
yoogvb
4
hcch
23
mzmqnnrkurfmmfrukrnnqsm
Sample Output 0

3
2
2
4
18
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
                int n = in.nextInt();
                String str = in.nextLine();
                
                int ans = 0;
                for(int i=0;i<n;i++) {
                    // odd  len palindrome
                    int p1=i,p2 = i;
                    while((p1>=0 && p2<n) && str.charAt(p1) == str.charAt(p2)) {
                        p2++;
                        p1--;
                    }
                    
                    if(p2-p1-1 > ans) {
                        ans = p2-p1-1;
                    }
                    
                    // even len palindrome
                    p1=i-1;
                    p2 = i;
                    while((p1>=0 && p2<n) && str.charAt(p1) == str.charAt(p2)) {
                        p2++;
                        p1--;
                    }
                    
                    if(p2-p1-1 > ans) {
                        ans = p2-p1-1;
                    }
                   
                }
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
