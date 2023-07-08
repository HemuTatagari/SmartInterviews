/*

Given a sequence of N numbers: S1, ..., SN, determine how many subsequences of S have a sum between A and B inclusive.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, first line contains - N, A, B separated by space. The next line contains the sequence of N numbers.

Constraints

50 points
1 <= T <= 100
1 <= N <= 15

150 points
1 <= T <= 100
1 <= N <= 30

General Constraints
-107 <= A <= B <= 107
-107 <= S[i] <= 107

Output Format

For each test case, print the result, separated by newline.

Sample Input 0

2
3 -1 2
1 -2 3
5 5 15
1 4 -3 6 4
Sample Output 0

5
20
Explanation 0

Self Explanatory

  */

// note:- used Fast I/O template

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
                Long a = in.nextLong();
                Long b = in.nextLong();
                
                long[] arr = new long[n];
                for(int i=0;i<n;i++) {
                    arr[i] = in.nextLong();
                }
                
                int mid = (int)Math.ceil(n/2);
                
                ArrayList<Long> subSum1 = new ArrayList<>();
                ArrayList<Long> subSum2 = new ArrayList<>();
                
                
                getSubSequences(arr,mid+1,0,subSum1,0L);
                getSubSequences(arr,n,mid+1,subSum2,0L);
                
                
                
                
                
                ///////
                
                Collections.sort(subSum2);
                
                int count = 0;
                
                for(int i=0;i<subSum1.size();i++) {
                    
                    
                    int flr = floorr(subSum2,subSum2.size(),b-subSum1.get(i));
                    int cl = ceill(subSum2,subSum2.size(),a-subSum1.get(i));
                    
                    
                    
                    
                    
                    if((subSum1.get(i)+subSum2.get(flr) >= a && subSum1.get(i)+subSum2.get(flr) <= b) || (subSum1.get(i)+subSum2.get(cl) >= a && subSum1.get(i)+subSum2.get(cl) <= b) ) {
                        count += (flr - cl+1);
                    }
                    
                }
                
                System.out.println(count);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    
    public static void getSubSequences(long[] arr, int n,int index,ArrayList<Long> al,Long sum) {
        if(index >= n) {
            al.add(sum);
            return;
        }
        getSubSequences(arr,n,index+1,al,sum);
        
        getSubSequences(arr,n,index+1,al,sum+arr[index]);
        
    }
    
    public static int floorr(ArrayList<Long> al,int n,long target) {
        int low =0, high = n-1;
        int flr = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(al.get(mid) <= target) {
                flr = mid;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        
        return flr;
    }
    
    public static int ceill(ArrayList<Long> al,int n,long target) {
        int low =0, high = n-1;
        int cl = n-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(al.get(mid) >= target) {
                cl = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        
        return cl;
    }
}
