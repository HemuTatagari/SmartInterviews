/*

Given an array, find the length of the longest subsequence whose elements can be re-arranged in a strictly increasing contiguous order. The difference between 2 adjacent elements in the subsequence, after re-arrangement, should be exactly 1.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - size of the array. The next line contains N integers - the elements of the array.

Constraints

1 <= T <= 1000
1 <= N <= 10000
-100000 <= ar[i] <= 100000

Output Format

For each test case, print the length of the longest subsequence, separated by newline.

Sample Input 0

3
8
21 -22 -22 5 -31 -24 5 -23 
10
18 -33 31 33 30 -14 32 30 16 17 
6
6 3 8 5 2 5 
Sample Output 0

3
4
2
Explanation 0

Test Case 1
Subsequence is: -22, -24, -23.

Test Case 2
Subsequence is: 31, 33, 30, 32.

Test Case 3
Subsequence is: 6, 5 or 3, 2.




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
                int n = in.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<n;i++) {
                    arr[i] = in.nextInt();
                }
                
                int[] count = new int[100001];
                int[] neg = new int[100001];
                
                for(int i=0;i<n;i++) {
                      if(arr[i] < 0) {
                          neg[arr[i]*-1]++;
                     }
                      else{
                         count[arr[i]]++;
                     }
                }
                
                int count1 = 0,res=0;
                for(int i=100000;i>=0;i--) {
                    if(count[i] >= 1) {
                        count1++;
                        res = Math.max(count1,res);
                    }
                    else {
                        
                        count1 = 0;
                        
                    }
                }
                //count1=0;
                for(int i=1;i<100001;i++) {
                    if(neg[i] >= 1) {
                        count1++;
                        res = Math.max(count1,res);
                    }
                    else {
                        
                        
                        count1 = 0;
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
