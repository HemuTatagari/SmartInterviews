/*

Given a 2D square matrix, print the matrix in a spiral order. Refer examples for more details. From interviews point of view, after you scan the matrix in a 2D array, try to print the matrix in a spiral order without using any extra space.


Input Format

First line of input contains T - number of test cases. First line of each test case contains N - size of the matrix [NxN]. Its followed by N lines each containing N integers - elements of the matrix.

Constraints

1 <= T <= 100
1 <= N <= 100
-100 <= ar[i][j] <= 100

Output Format

For each test case, print the matrix in a spiral order, separated by newline.

Sample Input 0

4
1
1
2
1 2
4 3
3
1 2 3
8 9 4
7 6 5
5
-44 25 -52 69 -5 
17 22 51 27 -44 
-79 28 -78 1 -47 
65 -77 -14 -21 -6 
-96 43 -21 -20 90 
Sample Output 0

1 
1 2 3 4 
1 2 3 4 5 6 7 8 9 
-44 25 -52 69 -5 -44 -47 -6 90 -20 -21 43 -96 65 -79 17 22 51 27 1 -21 -14 -77 28 -78 
Explanation 0

Self Explanatory

    */

// Note :- used fast input/output template
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
                int[][] mat = new int[n][n];
                
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++) {
                        mat[i][j] = in.nextInt();
                    }
                }
                boolean count = true;
                int i=0,j=0;
                int r = n-1, d= n-1, u = 1, l = 0;
                
                while(count) {
                    count = false;
                    while(j <= r) {
                        out.print (mat[i][j]+" ");
                        j++;
                        count = true;
                    }
                    
                    j--;
                    i++;
                    r--;
                    
                    while(i <= d) {
                        out.print (mat[i][j]+" ");
                        i++;
                        count = true;
                    }
                    
                    j--;
                    i--;
                    d--;
                    
                    while(j >= l) {
                        out.print (mat[i][j]+" ");
                        j--;
                        count = true;
                    }
                    
                    j++;
                    i--;
                    l++;
                    
                    while(i >= u) {
                        out.print (mat[i][j]+" ");
                        i--;
                        count = true;
                    }
                    
                    j++;
                    i++;
                    u++;
                    
                    
                    
                }
                
                
               out.println(""); 
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
