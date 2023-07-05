
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
