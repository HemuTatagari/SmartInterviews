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
