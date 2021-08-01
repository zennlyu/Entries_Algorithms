package com.algorithms.nnu.Dynamic_Programming.matrixmul;

/**
 *
 * @author YuYunTan(谭淇蔚)
 *定义数组P[i]
 *p[i]的含义有两层
 *指的是：
 *1. 第i个矩阵的列
 *2. 第i+1个矩阵的行
 *
 *思路：
 *步骤：
 *划分阶段（子问题）并刻画
 *将原问题划分成两个子问题。如果原问题获得最优值。则子问题的应该也是最优的。
 *将矩阵连乘积A1A2A3A4简记为A(1:n)
 *设最优计算次序在矩阵Ak和Ak+1之间将矩阵链断开，1≤k<n，则其相应完全加括号方式为
 *(A1...Ak)(Ak+1...An)
 *考虑任意大小(起点为i，终点为j)的子问题
 *将矩阵连乘积 AiAi+1Ai+2...Aj 简记为A(i:j) ，这里i≤j
 *考察计算A(i:j)的最优计算次序。设这个计算次序在矩阵Ak和Ak+1之间将矩阵链断开，i≤k<j，则其相应完全加括号方式为
 *(Ai...Ak)(Ak...Aj)
 *计算量：A(i:k)的计算量加上A(k+1:j)的计算量，再加上A(i:k)和A(k+1:j)相乘的计算量。
 *特征：计算A(i:j)的最优次序所包含的计算矩阵子链 A(i:k)和A(k+1:j)的次序也是最优的。
 *矩阵连乘计算次序问题的最优解包含着其子问题的最优解。
 *设计算A(i:j)，1≤i≤j≤n，所需要的最少数乘次数m[i,j]，
 *设计算A(i:k)的最少数乘次数为m[i,k]，计算A(k+1:j)最少数乘次数为m[K+1,j]
 *最后两个矩阵相乘即A(i:k)A(k+1,j)所做的乘法次数：p[i-1]p[k]p[j]
 *m[i,j]=m[i][k]+m[k+1][j+1]+p[i-1]p[k]p[j];
 *
 *s[i][j]中的数字k表明计算矩阵链A[i:j]的最佳方式应在矩阵A[k]和A[k+1]之间断开
 *即最佳的加括号方式为(A[1:k])(A[k+1,j])
 *因此s[1][n]记录的信息可知A[1:n]的最佳的加括号方式为：
 *A[1:s[1][n])(A[s[1][n]:n)
 */
public class MatirxMul {

    public static void main(String[] args) {

        //int []p = {50,10,40,30,5};
        int []p = {30,35,15,5,10,20,25};//两组数据做测试
        //p[i]的含义有两层指的是：
        //1. 第i个矩阵的列
        //2. 第i+1个矩阵的行
        int [][]m = new int [p.length+1][p.length+1];//记录连乘次数
        int [][]s = new int [p.length+1][p.length+1];//记录最佳分割位置
        MatrixChain(p,m,s);
        System.out.println("矩阵计算量最小次数矩阵");
        PrintMatrixMul(m,p.length);
        System.out.println("相对于M矩阵的最优断开位置矩阵S");
        PrintMatrixMul(s,p.length);
        System.out.println("乘法的最优次序：");
        traceback(s,1,p.length-1);
    }
    private static void PrintMatrixMul(int[][] m,int n) {
        // TODO 自动生成的方法存根
        //打印数组
        for(int i = 1;i<=n-1;i++){
            for(int j =1;j<=n-1;j++){
                System.out.print(m[i][j]+"\t");
                if(j % (n-1) ==0)System.out.print("\n");
            }
        }

    }
    public static void MatrixChain(int []p,int [][]m,int [][]s){
        //计算最优值
        for(int i=1;i<=p.length;i++){
            m[i][i]=0;
        }
        for(int r = 2; r<= p.length;r++){
            for(int i=1;i<=p.length-r;i++){
                int j = i+r-1;
                m[i][j] = m[i+1][j]+p[i-1]*p[i]*p[j];
                s[i][j] = i;
                for(int k =i+1;k<j;k++){
                    int t = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j]){
                        m[i][j] = t;
                        s[i][j]=k;
                    }
                }
            }

        }
    }
    private static void traceback(int[][] s, int i, int j) {
        // TODO 自动生成的方法存根
        //输出最优计算次序
        //观察解的格式，发现如果只有单个的A，那么只要输出Ai，前后会有括号
        //如果是连续的A，则规律是i+1=j，那么此时不要使用括号
        //在分割点左边是用“（”，在分割点右边是用“）”,此时采用递归去求解使用括号的位置
        if(i==j)
            System.out.print("A"+i);
        else if(i+1==j)
            System.out.print(" (A"+i+" * "+" A"+j+") ");
        else{
            System.out.print(" (");
            traceback(s,i,s[i][j]);
            traceback(s,s[i][j]+1,j);
            System.out.print(") ");
        }
    }
}