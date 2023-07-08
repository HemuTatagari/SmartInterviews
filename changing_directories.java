/*

Zack is learning Operating Systems. He came across the following commands:
cd - changes the location of working directory, and
pwd - display the present working directory

If the cd parameter contains "..", that means you have to step back one directory. The path of directories is separated by slashes "/". The default root directory is "/". Your task is to print the current working directory, for each "pwd" command.

Input Format

First line of input contains T - number of test cases. For each test case, first line of input contains N - number of commands. Its followed by N lines, each containing either a "cd <path>" or a "pwd" command. Each "cd" command will end with a "/".

Constraints

1 <= T <= 100
1 <= N <= 100
1 <= len(path) <= 200
path[i] ∈ ('a' - 'z', '.', '/')

Output Format

For each "pwd" command, print the present working directory, separated by new line. Print newline between output of test cases.

Sample Input 0

2
8
pwd
cd /Users/Guest/
pwd
cd ../Admin/Desktop/
pwd
cd /Users/Guest/Desktop/
cd os/labs/
pwd
6
cd /sem/networks/labs/
pwd
cd ../../os/labs/../slides/
pwd
cd /
pwd
Sample Output 0

/
/Users/Guest/
/Users/Admin/Desktop/
/Users/Guest/Desktop/os/labs/

/sem/networks/labs/
/sem/os/slides/
/
Explanation 0

Self Explanatory

  */


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
 Scanner sc=new Scanner(System.in);
       int t= sc.nextInt();
        for(int tc=1;tc<=t;tc++)
        {
            int op=sc.nextInt();
            Deque<String> dq=new LinkedList<String>();
            dq.push("/");
            sc.nextLine();
            for(int o=1;o<=op;o++)
            {
                String[] cmd=sc.nextLine().trim().split(" ");
                /*for(int w=0;w<cmd.length;w++)
                {
                    System.out.print(cmd[w]+" ");
                }*/
               // System.out.println();
                
                if(cmd[0].equals("pwd"))
                {
                    
                    System.out.println(String.join("",dq));
                }
                else
                {
                    //System.out.println(cmd[0]+"cd");
                    if(cmd[1].charAt(0)=='/')
                    {
                        //System.out.println("root again");
                        
                        dq.clear();
                    }
                    if(cmd[1].equals("/"))
                    {
                        dq.add("/");
                    }
                    else
                    {
                    String[] directories=cmd[1].split("/");

                    for(int d=0;d<directories.length;d++)
                    {
                       if(directories[d].equals(".."))
                       {
                           dq.removeLast();
                       }
                        else
                        {
                         dq.add(directories[d]+"/");   
                        }


                    }
                    }
                    
                }
              
            }
              System.out.println();
        }
    }
}
