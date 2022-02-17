package com.nnu.Dynamic_Programming.zeronepack;

import java.util.Scanner;

/**
 * 使用二维数组非递归的方法求解0/1背包问题
 */
public class ZeroOnePack {
    // N表示物体的个数，V表示背包的载重
    int N,V;
    //用于存储每个物体的重量，下标从1开始
    private int[] weight;
    //存储每个物体的收益，下标从1开始
    private int[] value;
    //二维数组，用来保存每种状态下的最大收益
    private int[][] F;

    /**
     * 使用非递归方式，求解F[0 .. N][0 .. V]，即for循环从下至上求解
     */
    public void ZeroOnePackNonRecursive() {
        //对二维数组F进行初始化
        for(int j = 0; j <= V; j++) {
            F[0][j] = 0;
        }

        //注意边界问题，i是从1开始的，j是从0开始的
        //因为F[i - 1][j]中i要减1
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                //如果容量为j的背包放得下第i个物体
                if(j >= weight[i]) {
                    F[i][j] = Math.max(F[i - 1][j - weight[i]] + value[i], F[i - 1][j]);
                }else {
                    //放不下，只能选择不放第i个物体
                    F[i][j] = F[i - 1][j];
                }
            }
        }

        //打印所有结果，我们要求的是F[N][V]
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 求解F[n][m]这个最优值具体选取哪几样物品能获得最大价值，但只会输出一种情况
     * @param n     表示前n个物体，n <= N
     * @param v     表示背包的容量，v <= V
     */
    public void printResult(int n, int v) {
        boolean[] isAdd = new boolean[n + 1];

        for(int i = n; i >= 1; i--) {
            if(F[i][v] == F[i-1][v])
                isAdd[i] = false;
            else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(isAdd[i] + " ");
        }
        System.out.println();
    }

    /**
     * 输入格式：
     5 10
     2 2 6 5 4
     6 3 5 4 6
     * result:15
     * 第一行是物体个数、背包总空间；
     * 第二行是每个物体的空间；
     * 第三行是每个物体的收益。
     */
    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        //下标从1开始，表示第1个物品
        weight = new int[N + 1];
        value = new int[N + 1];
        F = new int[N + 1][V + 1];//注意是 N + 1，因为需要一个初始状态F[0][0]，表示前0个物品放进空间为0的背包的最大收益

        for(int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            value[i] = sc.nextInt();
        }
    }



    public static void main(String[] args) {
        ZeroOnePack zop = new ZeroOnePack();
        zop.init();
        zop.ZeroOnePackNonRecursive();
        zop.printResult(zop.N,zop.V);
    }
}