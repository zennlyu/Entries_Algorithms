package com.princeton.algs4.exercise.A;

/***************************************************************************************************
 * 1.1.21 编写一段程序，从标准输入按行读取数据，其中每行都包含一个名字和两个整数。
 * 然后用 printf() 打印一张表格，每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数的结果，精确到小数点后三位。
 * 可以用这种程序将棒球球手的击球命中率或者学生的考试分数制成表格。
****************************************************************************************************/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SheetTest
{
    private static class Node
    {
        String Name;
        String v1;
        String v2;
        double v3;
    }

    public static void main(String[] args)
    {
        int N=Integer.parseInt(args[0]);
        Node[] list=new Node[N];
        int index=0;
        while (!StdIn.isEmpty() )
        {

            Node Item=new Node();
            Item.Name=StdIn.readString();
            Item.v1=StdIn.readString();
            Item.v2=StdIn.readString();
            Item.v3=Double.parseDouble(Item.v1)/Double.parseDouble(Item.v2);
            list[index]=Item;
            index++;
            if(index==N) break;
        }
        StdOut.printf("---------------------------\n");
        StdOut.printf("Name    V1      V2        V3\n");
        StdOut.printf("---------------------------\n");
        for(int i=0;i<N;i++)
            StdOut.printf("%-8s%-8s%-8s%-8.3f\n",list[i].Name,list[i].v1,list[i].v2,list[i].v3);
    }
}