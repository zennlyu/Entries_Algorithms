package com.princeton.algs4.AFundementals.exercise;

/****
 * 1.1.13 编写一段代码，打印出一个M行N列的二维数组的转置(交换行和列）
 * ****/
import edu.princeton.cs.algs4.StdOut;

public  class MatrixReverse
{
    public static void main(String[] args)
    {
        //初始化
        int M=Integer.parseInt(args[0]);
        int N=Integer.parseInt(args[1]);
        String[][] array=new String[M][N];
        for (int row=0;row<M;row++)
            for(int col=0;col<N;col++)
                array[row][col]=row+","+col;

        //打印未转置的元素
        int width=Integer.toString(M).length()+ Integer.toString(N).length()+1+4;
        String format="%"+Integer.toString(width)+"s";
        StdOut.printf(format," ");
        for (int col=0;col<N;col++)
            StdOut.printf(format,col);
        StdOut.printf("\n");
        //
        for (int row=0;row<M;row++)
        {
            StdOut.printf(format,row);
            for (int col=0;col<N;col++)
                StdOut.printf(format,array[row][col]);
            StdOut.printf("\n");
        }

        //打印转置后的元素
        StdOut.printf("\n\n\n");
        StdOut.printf(format," ");
        for (int row=0;row<M;row++)
            StdOut.printf(format,row);
        StdOut.printf("\n");
        //
        for (int col=0;col<N;col++)
        {
            StdOut.printf(format,col);
            for (int row=0;row<M;row++)
                StdOut.printf(format,array[row][col]);
            StdOut.printf("\n");
        }
    }//end main
}//end class