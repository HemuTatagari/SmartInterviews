/*

You are given an integer K and an array of distinct integers of size N. Find the Kth smallest element from the array.
Note: Try solving using MaxHeap or Quick Select, don't solve using sorting.

Input Format

First line of input contains T - number of test cases. For each test case, the first line contains N - the size of the array. The second line contains N integers - the elements of the array.

Constraints

1 <= T <= 100
1 <= K <= N <= 105
0 <= A[i] <= 105

Output Format

For each test case, print the Kth smallest element from the array, separated by newline.

Sample Input 0

2
5 3
1 5 13 2 8
6 2
10 1 20 8 31 12
Sample Output 0

5
8
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
                int temp = n-k;
                MaxHeap maxHeap = new MaxHeap();
                
                while(k-- > 0) {
                    maxHeap.insert(in.nextInt());
                }
                
                while(temp-- > 0) {
                    maxHeap.insert(in.nextInt());
                    maxHeap.deleteMax();
                }
                
                out.println(maxHeap.getMax());
                
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}



class MaxHeap {
    
    ArrayList<Integer> al;
    
    MaxHeap() {
        al = new ArrayList<Integer>();
    }
    
    void insert(int x) {
        int idx = al.size();
        int parent_idx = (idx-1)/2;
        al.add(x);
        while(idx > 0 && al.get(idx) > al.get(parent_idx)) {
            swap(idx,parent_idx);
            idx = parent_idx;
            parent_idx = (idx-1)/2;
        }
    }
    
    void deleteMax() {
        int len = al.size();
        int idx = len-1;
        swap(0,idx);
        al.remove(al.get(idx));
        len--;
        idx = 0;
        while(idx < len) {
            int maxi = Integer.MIN_VALUE;
            if((2*idx)+1 < len) {
                if((2*idx)+2 < len) {
                    if(al.get((2*idx)+1) > al.get((2*idx)+2)) {
                        maxi = (2*idx)+1;
                    }
                    else {
                        maxi = (2*idx)+2;
                    }
                }
                else {
                    maxi = (2*idx)+1;
                }
            }
            else {
                break;
            }
            
            if(maxi != Integer.MIN_VALUE && al.get(maxi) > al.get(idx)) {
                swap(maxi,idx);
                idx = maxi;
            }
            else {
                break;
            }
        }
    }
    
    int getMax() {
        return al.get(0);
    }
    
    void swap(int i, int j) {
        int temp = al.get(i);
        al.set(i,al.get(j));
        al.set(j,temp);
        
        return;
    }
    
}
