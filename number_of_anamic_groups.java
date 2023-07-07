/*

You are given N strings of length M, count the number of anagramic groups. An anagramic group is a list of strings which are anagrams of each other.

Input Format

First line of input contains T - number of test cases. In each test case, the first line contains N - the number of strings and M - the length of each string, separated by a space. The N subsequent lines each contain a string of length M.

Constraints

1 <= T <= 100
1 <= N <= 100
1 <= M <= 1000
'a' <= str[i] <= 'z'

Output Format

For each test case, print the count of the number of anagramic groups in the given N strings, separated by newline.

Sample Input 0

2
5 4
arts
rank
star
rant
rats
9 5
tesla
start
slate
salte
tarts
aster
arson
astle
norse
Sample Output 0

3
5
Explanation 0

Test-Case 1
The strings "arts", "star" and "rats" can be grouped together because they are anagrams of each other. The total number of such groups is 3 and the groups are {"arts", "rats", "star"}, {"rant"} and {"rank"}.

  */


// note:- Fast I/O template used

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
                int len = in.nextInt();
                int n = in.nextInt();
                String arr[] = new String[len];
                HashSet<String> set = new HashSet<>();
                for(int i=0;i<len;i++) {
                    arr[i] = in.nextLine();
                    char[] ch =arr[i].toCharArray();
                    Arrays.sort(ch);
                    set.add(new String(ch));
                    
                }
                
                
                out.println(set.size());
                
                
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
