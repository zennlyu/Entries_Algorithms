package com.algorithms.nnu.Backtracking.mcoloring;

public class MColoringProblem {
    static int m;//颜色的数量
    static int[] x;//可行解
    static int n;//图的顶点个数
    static int[][] a;//图的邻接矩阵
    static long sum;//可行解个数
    public static long color(int mm,int[][] aa,int nn) {
        m=mm;
        n=nn;
        a=aa;
        sum=0;
        x=new int[n+1];
        for(int i=0;i<=n;i++)
            x[i]=0;
        backtrack(1);
        System.out.println("着色方案共有：");
        return sum;
    }
    public static void backtrack(int t) {
        if(t>n) {
            sum++;
            for(int i=1;i<=n;i++)
                System.out.print(x[i]+" ");
            System.out.println();
        }else {
            for(int i=1;i<=m;i++) {
                x[t]=i;
                if(ok(t))//剪枝函数
                    backtrack(t+1);
                x[t]=0;
            }
        }
    }
    public static boolean ok(int k) {
        for(int j=1;j<k;j++) {//教材此处是j<=n，但是我认为此时涂色只涂到第k个顶点，所以只需要对比前k个就行了
            if(a[k][j]==1&&x[j]==x[k])//相邻顶点颜色不能相同
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int mm=4;
        int nn=6;
        int[][] aa= {{-1,-1,-1,-1,-1,-1,-1},
                {-1,0,1,0,0,1,1},
                {-1,1,0,1,1,1,0},
                {-1,0,1,0,1,0,0},
                {-1,0,1,1,0,1,0},
                {-1,1,1,0,1,0,1},
                {-1,1,0,0,0,1,0}};
        System.out.println("着色方案如下：");
        System.out.println(color(mm, aa, nn));
    }
}