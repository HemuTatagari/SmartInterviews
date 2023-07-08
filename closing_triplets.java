/*

Given three arrays A, B and C, chose a triplet a, b, c such that a, b, c belongs to the arrays A, B, C respectively, such that the absolute difference between the maximum and minimum element of the chosen triplet is minimised, i.e., minimize |max(a,b,c)-min(a,b,c)|.

Input Format

First line of input contains T - number of test cases. Its followed by 6T lines, the first line contains N1 - the size of the array A and second line contains the elements of the array A. The third line contains N2 - the size of the array B and fourth line contains the elements of the array B. The fifth line contains N3 - the size of the array C and sixth line contains the elements of the array C.

Constraints

10 points
1 <= T <= 100
1 <= N1, N2, N3 <= 100
0 <= A[i], B[i], C[i] <= 109

30 points
1 <= T <= 100
1 <= N1, N2, N3 <= 500
0 <= A[i], B[i], C[i] <= 109

60 points
1 <= T <= 100
1 <= N1, N2, N3 <= 10000
0 <= A[i], B[i], C[i] <= 109

Output Format

For each test case, print the minimum absolute difference, separated by newline.

Sample Input 0

1
5
10 8 5 4 1 
3
6 9 15 
4
8 3 2 6 
Sample Output 0

1
Explanation 0

Test Case 1
The triplet (5,6,6) belongs to the arrays A, B, C respectively and it gives |max(a,b,c)-min(a,b,c)| = 1.

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
                //a
                int an = in.nextInt();
                
                int a[] = new int[an];
                for(int i=0;i<an;i++) {
                    a[i] = in.nextInt();
                }
                //b
                int bn = in.nextInt();
                
                int b[] = new int[bn];
                for(int i=0;i<bn;i++) {
                    b[i] = in.nextInt();
                }
                //c
                int cn = in.nextInt();
                
                int c[] = new int[cn];
                for(int i=0;i<cn;i++) {
                    c[i] = in.nextInt();
                }
                Arrays.sort(a);
                Arrays.sort(b);
                Arrays.sort(c);
                // code
                int p1=0,p2=0,p3=0;
                int ans = Integer.MAX_VALUE;
                int maxe =0,mine=0;
                while(p1<an && p2<bn && p3<cn) {
                    
                    
                   
                    
                    if(a[p1]<=b[p2] && a[p1]<=c[p3]) {
                        mine = a[p1];
                        if(b[p2]<c[p3]) {
                            maxe = c[p3];
                        }
                        else {
                            maxe = b[p2];
                        }
                        p1++;
                    } 
                    else if(b[p2]<a[p1] && b[p2]<c[p3]) {
                        mine = b[p2];
                        if(a[p1]<c[p3]) {
                            maxe = c[p3];
                        }
                        else {
                            maxe = a[p1];
                        }
                        p2++;
                    }
                    else {
                        mine = c[p3];
                        if(a[p1]<b[p2]) {
                            maxe = b[p2];
                        }
                        else {
                            maxe = a[p1];
                        }
                        p3++;
                    }
                     ans = Math.min(ans,maxe-mine);
                    
                }
                
                System.out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
