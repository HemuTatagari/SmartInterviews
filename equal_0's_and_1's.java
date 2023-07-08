/*

You are given an array of 0's and 1's. Find the length of the longest subarray which has an equal number of 0's and 1's.

Input Format

First line of input contains T - the number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Constraints

10 points
1 <= T <= 100
1 <= N <= 100

20 points
1 <= T <= 100
1 <= N <= 1000

70 points
1 <= T <= 1000
1 <= N <= 104

Output Format

For each test case, print the length of the longest subarray which has equal 0's and 1's, separated by a new line.

Sample Input 0

2
5
0 1 1 0 1
6
1 1 1 1 1 0
Sample Output 0

4
2
Explanation 0

Self Explanatory

  */

// note :- used Fast I/O template


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
                int arr[] = new int[n];
                
                for(int i=0;i<n;i++) {
                    if(in.nextInt() == 0) {
                        arr[i] = -1;
                    }
                    else {
                        arr[i] = 1;
                    }
                    
                }
                
                int prfx[] = new int[n];
                prfx[0] = arr[0];
                
                for(int i=1;i<n;i++) {
                    prfx[i] = prfx[i-1]+arr[i];
                }
                
                HashMap<Integer,Integer> map = new HashMap<>();
                int res = 0;
                for(int i=0;i<n;i++) {
                    if(prfx[i] == 0) {
                        res = Math.max(res,i+1);
                        continue;
                    }
                    
                    if(map.containsKey(prfx[i])) {
                        res = Math.max(res,i-map.get(prfx[i]));
                    }
                    else {
                        map.put(prfx[i],i);
                    }
                    
                    
                    
                }
                
                System.out.println(res);
                
                
                
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
