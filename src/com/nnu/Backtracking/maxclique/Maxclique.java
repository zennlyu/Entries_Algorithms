package com.nnu.Backtracking.maxclique;

/**
 * 最大团问题--回溯法
 * @author Lican
 *
 */
public class Maxclique {
    public int[] x;//当前解（x[i]=1表示i点在最大团中，=0表示不在团中）
    public int n;//图G的顶点数
    public int cn;//当前顶点数
    public int bestn;//当前最大顶点数
    public int[] bestx;//当前最优解
    public int[][] a;//图G的邻接矩阵,0：不连通；1：连通
    public int count;//图G的最大团个数

    public void backtrack(int i){
        if(i>n){
            for(int j=1;j<=n;j++){
                bestx[j]=x[j];
                System.out.print(x[j]+" ");
            }
            System.out.println();
            bestn=cn;
            count++;
            return;
        }
        else{
            boolean ok=true;
            for(int j=1;j<i;j++){//检查顶点i是否与当前团全部连接
                if(x[j]==1&&a[i][j]==0){
                    ok=false;
                    break;
                }
            }
            if(ok){//从顶点i到已选入的顶点集中每一个顶点都有边相连
                //进入左子树
                x[i]=1;
                cn++;
                backtrack(i+1);
                x[i]=0;
                cn--;
            }
            if(cn+n-i>=bestn){//当前顶点数加上未遍历的课选择顶点>=当前最优顶点数目时才进入右子树;如果不需要找到所有的解，则不需要等于
                //进入右子树
                x[i]=0;
                backtrack(i+1);
            }
        }
    }

    public int maxclique(int nn,int[][] aa){
        //初始化
        n=nn;
        a=aa;
        x=new int[n+1];
        bestx=x;
        cn=0;
        bestn=0;
        count=0;
        backtrack(1);
        return bestn;
    }

    public static void main(String[] args) {
        int[][] a={{-1,-1,-1,-1,-1,-1},{-1,0,1,0,1,1},{-1,1,0,1,0,1},{-1,0,1,0,0,1},{-1,1,0,0,0,1},{-1,1,1,1,1,0}};//a的下标从1开始，-1的值无用
        int n=5;
        Maxclique m=new Maxclique();
        System.out.println("图G的最大团解向量为：");
        System.out.println("图G的最大团顶点数为："+m.maxclique(n, a));
        System.out.println("图G的最大团个为："+m.count);
    }
}