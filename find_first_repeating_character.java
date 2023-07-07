/*

Given a string of characters, find the first repeating character.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single string of characters.

Constraints

1 <= T <= 1000
'a' <= str[i] <= 'z'
1 <= len(str) <= 104

Output Format

For each test case, print the first repeating character, separated by newline. If there are none, print '.'.

Sample Input 0

4
datastructures
algorithms
smartinterviews
hackerrank
Sample Output 0

a
.
s
a
Explanation 0

Self Explanatory

  */

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
                String str = in.nextLine();
                int[] arr = new int[26];
                boolean flag = true;
                for(int i=0;i<str.length();i++) {
                    arr[str.charAt(i)-97]++;
                }
                
                for(int i=0;i<str.length();i++) {
                    
                    if(arr[str.charAt(i)-97] > 1) {
                        out.println(str.charAt(i));
                        flag = false;
                        break;
                    }
                    
                }
                
                if(flag) {
                    out.println(".");
                }
            }
            out.close();
        } catch (Exception e) {
            System.out.println("her");
            return;
            
        }
    }
}
