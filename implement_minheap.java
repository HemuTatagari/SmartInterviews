/*

Perform Insert, delMin and getMin operations on a Min Heap. Implement Min Heaps and avoid using inbuilt library.

Input Format

First line of input contains T - number of operations. Its followed by T lines, each line contains either "insert x" or "delMin" or "getMin".

Constraints

1 <= T <= 106
-109 <= x <= 109

Output Format

For each "getMin" operation, print the minimum element, separated by newline. If the heap is empty, print "Empty".

Sample Input 0

10
insert 5
getMin
delMin
getMin
insert -15
insert 10
insert -30
getMin
delMin
getMin
Sample Output 0

5
Empty
-30
-15
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
            
            int T = in.nextInt();
        MinHeap minHeap = new MinHeap();
        while(T-- > 0) {
            String query = in.next();
            if(query.equals("getMin")) {
                int ans = minHeap.getMin();
                if(ans != Integer.MAX_VALUE) {
                    out.println(ans);
                }
                else {
                    out.println("Empty");
                }
                
            }
            else if(query.equals("delMin")) {
                minHeap.deleteMin();
            }
            else {
                int x = in.nextInt();
                minHeap.insert(x);
            }
        }
            
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}

class MinHeap {
    
    ArrayList<Integer> al;
    
    MinHeap() {
        al = new ArrayList<Integer>();
    }
    
    void insert(int x) {
        al.add(x);
        int idx = al.size()-1;
        
        
        while(idx > 0 && al.get(idx) < al.get((idx-1)/2)) {
            swap(idx,(idx-1)/2);
            idx = (idx-1)/2;
        }
    }
    
    void deleteMin() {
        int len = al.size();
        if(len == 0) {
            return;
        }
        al.set(0,al.get(len-1));
        al.remove(len-1);
        len--;
        int idx = 0;
        while(idx < len) {
            int mini = Integer.MIN_VALUE;
            if((2*idx)+1 < len) {
                if((2*idx)+2 < len) {
                    if(al.get((2*idx)+1) < al.get((2*idx)+2)) {
                        mini = (2*idx)+1;
                    }
                    else {
                        mini = (2*idx)+2;
                    }
                }
                else {
                    mini = (2*idx)+1;
                }
                
                if(al.get(mini) < al.get(idx)) {
                    swap(mini,idx);
                    idx = mini;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
            
            
            
        }
    }
    
    int getMin() {
        if(al.size() == 0) {
            return Integer.MAX_VALUE;
        }
        return al.get(0);
    }
    
    void swap(int i, int j) {
        int temp = al.get(i);
        al.set(i,al.get(j));
        al.set(j,temp);
        
        return;
    }
    
}
