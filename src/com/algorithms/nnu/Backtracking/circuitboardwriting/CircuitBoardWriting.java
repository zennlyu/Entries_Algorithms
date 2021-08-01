package com.algorithms.nnu.Backtracking.circuitboardwriting;

import java.util.Scanner;
/**
 * 电路板排线问题--回溯法（排列树）
 * @author Administrator
 *
 */

public class CircuitBoardWriting {
    public int n;                       //电路板数
    public int m;                       //连接块数
    public int [] x;                    //当前解
    public int[] bestx;                 //当前最优解
    public int[] total;                 //total[j]=连接块j的电路板数
    public int[] now;                   //now[j]=当前解中所含连接块j的电路板数
    public int bestd;                   //当前最优密度
    public int[][] b;                   //连接块数组

    public int arrange(int[][] bb){
        //初始化
        n=bb.length-1;
        m=bb[1].length-1;
        bestx=new int[n+1];
        x=new int[n+1];
        total=new int[m+1];
        now=new int[m+1];
        bestd=m+1;
        b=bb;
        //置x为单位排列
        //计算total[]
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                total[j]+=b[i][j];
            }
            x[i]=i;
        }

        backtrack(1,0);
        return bestd;
    }

    /**
     * 交换数组x下标为i，j的值
     * @param xx
     * @param i
     * @param j
     */
    public void swap(int[] xx,int i,int j){
        int temp=xx[i];
        xx[i]=xx[j];
        xx[j]=temp;
    }

    /**
     * 回溯
     * @param i 树的第i层
     * @param dd 上一层得到的最小密度
     */
    public void backtrack(int i,int dd){
        if(i==n){
            for(int j=1;j<=n;j++){
                bestx[j]=x[j];
            }
            bestd=dd;
        }else{
            for(int j=i;j<=n;j++){
                //选择x[j]为下一块电路板
                int d=0;
                for(int k=1;k<=m;k++){
                    now[k]+=b[x[j]][k];
                    if(now[k]>0&&total[k]!=now[k])
                        d++;
                }
                //更行d值
                if(dd>d)
                    d=dd;
                if(d<bestd){
                    swap(x,i,j);
                    backtrack(i+1,d);
                    swap(x,i,j);
                }
                for(int k=1;k<=m;k++){
                    now[k]-=b[x[j]][k];
                }
            }
        }
    }

    public static void main(String[] args) {
        int m=5;//连接块数
        int n=8;//电路板数
        int[][] b=new int[n+1][m+1];
        System.out.println("n块电路板为{B={1，2，3，4，5，6，7，8}");
        System.out.println("m个连接为：N1={4，5，6};N2={2，3};N3={1，3};N4={3，6};N5={7，8}");
        System.out.println("请输入二维数组b，其中b[i][j]值为1表示电路板i在连接块Nj中：");
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<=n;i++){
            String str=sc.nextLine();
            String[] s=str.split(" ");
            for(int j=1;j<=m;j++){
                b[i][j]=Integer.parseInt(s[j-1]);
            }
        }
        CircuitBoardWriting circuitBoardWriting =new CircuitBoardWriting();
        int bestd= circuitBoardWriting.arrange(b);
        System.out.println("最小密度为："+bestd);
        System.out.print("最优排列为：");
        for(int j = 1; j< circuitBoardWriting.bestx.length; j++){
            System.out.print(circuitBoardWriting.bestx[j]+" ");
        }
    }
}