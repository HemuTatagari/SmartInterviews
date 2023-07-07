/*

Given an array of integers and a window size K, find the number of distinct elements in every window of size K of the given array.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - size of the array and K - size of the window. The second line contains N integers - elements of the array.

Constraints

1 <= T <= 1000
1 <= N <= 10000
1 <= K <= N
-100 <= ar[i] <= 100

Output Format

For each test case, print the number of distinct elements in every window of size K, separated by newline.

Sample Input 0

3
5 3
-2 -4 -2 4 -2 
10 7
3 -4 -3 -4 -2 0 2 -2 6 0 
17 13
-5 -1 4 8 -5 -3 -4 7 4 -4 0 8 0 -2 3 2 5 
Sample Output 0

2 3 2 
6 5 6 5 
8 9 9 10 11 
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
                int n = in.nextInt();
                int k = in.nextInt();
                int arr[] = new int[n];
                
                for(int i=0;i<n;i++) {
                    arr[i] = in.nextInt();
                }
                
                
                
                int low = 0, high = k-1;
                HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
                for(int i=low;i<=high;i++) {
                       map.put(arr[i], map.getOrDefault(arr[i],0)+1); 
                }
                out.print (map.size()+" ");
                low++;
                high++;
                while(high < n) {
                    if(map.get(arr[low-1]) == 1) {
                        map.remove(arr[low-1]);
                    }
                    else {
                        map.put(arr[low-1],map.get(arr[low-1])-1);
                    }
                    map.put(arr[high],map.getOrDefault(arr[high],0)+1);
                    out.print (map.size()+" ");
                    low++;
                    high++;
                }
                
                out.println("");
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
