package com.nnu.Backtracking.flowshop;

/**
 * 批处理作业调度问题--回溯法（排列树）
 * @author Administrator
 *
 */
public class FlowShop {
    int n;                          // 作业数
    int f1;                         // 机器1完成处理时间
    int f;                          // 完成时间和
    int bestf;                      // 当前最优值
    int[][] m;                      // 各作业所需的处理时间
    int []x;                        // 当前作业调度
    int[] bestx;                    // 当前最优作业调度
    int[] f2;                       // 机器2完成处理时间
    public FlowShop(int n,int[][] m){
        this.n=n;
        this.m=m;
        f1=0;
        f=0;
        bestf=10000;                // 给定初始值
        bestx=new int[n+1];
        x=new int[n+1];

        for(int i=1;i<=n;i++){      // 初始化，x[i]为原始排序
            x[i]=i;
        }
        f2=new int[n+1];
    }
    public  void swap(int[] x,int i,int j){
        int temp=x[i];
        x[i]=x[j];
        x[j]=temp;
    }

    public  void backtrack(int i){
        if(i>n){
            for(int j=1;j<=n;j++)
                bestx[j]=x[j];
            bestf=f;
        }
        else{
            for(int j=i;j<=n;j++){
                f1+=m[x[j]][1];                                 // 作业x[j]在第一台机器的时间
                f2[i]=((f2[i-1]>f1)?f2[i-1]:f1)+m[x[j]][2];     //f2[i]等于f2[i-1]和f1中较大者加上作业x[j]在第2台机器的时间
                f+=f2[i];
                if(f<bestf){
                    swap(x,i,j);
                    backtrack(i+1);
                    swap(x,i,j);
                }
                f1-=m[x[j]][1];
                f-=f2[i];
            }
        }
    }
    public static void main(String[] args) {
        int n=3;
        int[][] m= {        // m 的下标从 1 开始，因此第一行的 0 和每一行第一列的 0 无用
                {0,0,0},
                {0,2,1},
                {0,3,1},
                {0,2,3}
        };
        FlowShop f=new FlowShop(n,m);
        f.backtrack(1);
        System.out.println("最优批处理作业调度顺序为：");
        for(int i=1;i<=n;i++)
            System.out.print(f.bestx[i]+" ");
        System.out.println();
        System.out.println("最优调度所需的最短时间为："+f.bestf);
    }
}

/*
    运行结果：
    最优批处理作业调度顺序为：
    1 3 2
    最优调度所需的最短时间为：18
*/