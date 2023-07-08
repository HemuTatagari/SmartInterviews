/*

You are given an array of integers of size N. You are also given Q queries consisting of three integers i, j and x. For each query, increment each element of the array from index i to j by a value of x. At the end, print the largest element of the array.

Input Format

First line of input contains T - number of test cases. For each test case, the first line contains N - the size of the array. The second line contains N integers - the elements of the array. The third line contains Q - the number of queries. The Q subsequent lines each contain 3 integers i, j - the indices denoting the subarray and x - the value to be added to the elements of the subarray .

Constraints

30 points
1 <= N <= 102
1 <= Q <= 102

70 points
1 <= T <= 100
1 <= N <= 105
1 <= Q <= 104

General Constraints
1 <= T <= 100
-105 <= A[i], x <= 105
0 <= i <= j < N

Output Format

For each test case, after processing all the queries, print the max element of the entire array, separated by newline.

Sample Input 0

2
5
1 2 3 4 5
2
0 3 7
1 2 2
6
4 10 -1 2 8 -3
1
3 5 6
Sample Output 0

12
14
Explanation 0

Test-Case 1
Query 1: Adding 7 to each element of the array from indices 0 to 3 will make the array [8, 9, 10, 11, 5].
Query 2: Adding 2 to each element of the array from indices 1 to 2 will make the array [8, 11, 12, 11, 5].
The max element of the array is 12.

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
                long[] a = new long[n];
                long[] b = new long[n];
                
                for(int i=0;i<n;i++) {
                  a[i] = in.nextInt();
                }
                
                long maxe = Long.MIN_VALUE;
                int tc = in.nextInt();
                while(tc-- > 0) {
                    int i = in.nextInt();
                    int j = in.nextInt();
                    long x = in.nextLong();
                    
                    b[i]+=x;
                    if(j!= n-1) {
                        b[j+1]-=x;
                    }
                }
                maxe = a[0]+b[0];
                for(int i=1;i<n;i++) {
                    b[i] = b[i-1]+b[i];
                    a[i] = a[i]+b[i];
                    maxe = Math.max(maxe,a[i]);
                    
                }
                
                System.out.println(maxe);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
