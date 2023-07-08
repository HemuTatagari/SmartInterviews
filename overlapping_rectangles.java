/*

Given 2 rectangles parallel to coordinate axes, find the area covered by them.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-1. The second line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-2.

Constraints

1 <= T <= 10000
-106 < x,y <= 106
(xbl, ybl) < (xtr, ytr)

Output Format

For each test case, print the area covered by the 2 rectangles, separated by newline.

Sample Input 0

4
2 5 4 6
1 2 5 4
-4 -3 -2 5
-3 -5 1 3
1 0 3 5
2 3 5 8
-2 2 4 4
-3 1 5 5
Sample Output 0

10
42
23
32
Explanation 0

Self Explanatory

*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int tc=1;tc<=n;tc++)
        {
            long[] first=new long[4];
            long[] second=new long[4];
            for(int i=0;i<4;i++)
            {
                first[i]=sc.nextInt();
            }
            for(int j=0;j<4;j++)
            {
                second[j]=sc.nextInt();
            }
            long a=findArea(first);
            long b=findArea(second);
            
            //long intersection_rec_width=Math.max(first[0],second[0])-Math.min(first[2],second[2]);
            //long intersection_rec_height=Math.max(first[1],second[1])-Math.min(first[3],second[3]);
            long intersection_rec_width=Math.min(first[2],second[2])-Math.max(first[0],second[0]);
            long intersection_rec_height=Math.min(first[3],second[3])-Math.max(first[1],second[1]);
            long overlap = 0;
            if(intersection_rec_width > 0) {
                overlap=intersection_rec_width*intersection_rec_height;
            }
            
            
             // System.out.println(a+" "+b);
            long total=-1;
            if(overlap>=0)
            {
                total=(a+b)-overlap;
            }
            else
            {
                total=(a+b);
            }
            System.out.println(total);
        }
    }
    public static long findArea(long[] points)
    {
        /*for(int i=0;i<points.length;i++)
        {
            System.out.print(points[i]+" ");
        }*/
        //System.out.println();
        long width=points[2]-points[0];
        long height=points[3]-points[1];
        return(width*height);
    }
}
