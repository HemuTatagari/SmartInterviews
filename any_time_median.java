/*

Given an integer array, print the median for the sub-array 0 to i, for every i, 0<=i<=N-1.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines - the first line contains N - the size of the array. The second line contains N integers - the elements of the array.

Constraints

30 points
1 <= T <= 100
1 <= N <= 103

70 points
1 <= T <= 100
1 <= N <= 104

General Constraints
-104 <= A[i] <= 104

Output Format

For each test case, print the median for the sub-array 0 to i, for every i, separated by space. Print new line between output of different test cases.
Note: In case of even length sub-array, print the smaller element as the median.

Sample Input 0

2
5
-10 14 11 -5 7 
3
2 -5 14 
Sample Output 0

-10 -10 11 -5 7 
2 -5 2 
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
                int n = in.nextInt();
                int arr[] = new int[n];
                
                for(int i=0;i<n;i++) {
                    arr[i] = in.nextInt();
                }
                
                MaxHeap left = new MaxHeap();
                MinHeap right = new MinHeap();
                
                for(int i=0;i<n;i++) {
                    if(left.getlen() == 0 || arr[i] < left.getMax()) {
                        left.insert(arr[i]);
                    }else{
                        right.insert(arr[i]);
                    }
                    
                    if((left.getlen() - right.getlen() == 1) || (left.getlen() - right.getlen() == 0) ){
                        int y = 1; //pass
                    }
                    else if(left.getlen() > right.getlen()) {
                        int x = left.getMax();
                        left.deleteMax();
                        right.insert(x);
                    }
                    else {
                        int x = right.getMin();
                        right.deleteMin();
                        left.insert(x);
                    }
                    
                    out.print(left.getMax()+" ");
                }
                out.println("");
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
        al.add(x);
        int idx = al.size()-1;
        
        
        while(idx > 0 && al.get(idx) > al.get((idx-1)/2)) {
            swap(idx,(idx-1)/2);
            idx = (idx-1)/2;
        }
    }
    
    void deleteMax() {
        int len = al.size();
        if(len == 0) {
            return;
        }
        al.set(0,al.get(len-1));
        al.remove(len-1);
        len--;
        int idx = 0;
        while(idx < len) {
            int maxx = Integer.MIN_VALUE;
            if((2*idx)+1 < len) {
                if((2*idx)+2 < len) {
                    if(al.get((2*idx)+1) > al.get((2*idx)+2)) {
                        maxx = (2*idx)+1;
                    }
                    else {
                        maxx = (2*idx)+2;
                    }
                }
                else {
                    maxx = (2*idx)+1;
                }
                
                if(al.get(maxx) > al.get(idx)) {
                    swap(maxx,idx);
                    idx = maxx;
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
    
    int getMax() {
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
    
    int getlen() {
        return al.size();
    }
    
    
}

/*class MaxHeap {
    
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
    
    int getlen() {
        return al.size();
    }
    
}
*/

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
    
    int getlen() {
        return al.size();
    }
    
    
}
