/*

Given a string without duplicates, print all the permutations of the string in a lexicographically order.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each contains a single string consisting only of lowercase Enghish alphabets.

Constraints

For each test case, print the test case number as shown, followed by all the permutations of the string in a lexicographically order, separated by newline.

Output Format

1 <= T <= 100
1 <= len(str) <= 8

Sample Input 0

2
algo
ds
Sample Output 0

Test Case #1:
aglo
agol
algo
alog
aogl
aolg
galo
gaol
glao
gloa
goal
gola
lago
laog
lgao
lgoa
loag
loga
oagl
oalg
ogal
ogla
olag
olga
Test Case #2:
ds
sd
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
    
    static void swap(char[] str, int i, int j)
    {
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
    } 
    
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            int cases = 1;
            while(testCases-- > 0){
                // write code here
                String str = in.nextLine();
                int n = str.length();
                
                
                char[] c = str.toCharArray();
                Arrays.sort(c);
                out.println("Test Case #"+cases+":");
                
                
                boolean flag = false;
                
                
                int fc=0, sc=0;
                
                while(!flag) {
                    out.println(new String(c));
                    int k;
                    for(k=n-2;k>=0;--k) {
                        if((int)c[k] < (int)c[k+1]) {
                            fc = k;
                            break;
                        }
                    }
                    
                    if(k == -1) {
                        flag = true;
                    }
                    else {
                        //find ceil
                        sc = fc+1;
                        for(int i=fc+1; i<n;i++) {
                            if(((int)c[i] > (int)c[fc]) && ((int)c[i] < (int)c[sc])) {
                                sc = i;
                            }
                        }
                        
                        swap(c,fc,sc);
                        
                        int l = fc +1, h=n-1;
                        while ( l < h) {
                            swap(c, l, h);
                            l++;
                            h--;
                        }
                        
                        
                        
                    }
                    
                    
                    
                }
                
                cases++;
                
            }
            out.close();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
