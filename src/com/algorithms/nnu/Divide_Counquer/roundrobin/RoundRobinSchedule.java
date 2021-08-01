package com.algorithms.nnu.Divide_Counquer.roundrobin;

import java.util.Scanner;

/**
 *
 * @title RoundRobinSchedule
 * @describe 循环赛日程表：
 *           设有n=2^k个运动员要进行网球循环赛。
 *           现要设计一个满足以下要求的比赛日程表：
 *           (1)每个选手必须与其他n-1个选手各赛一次；
 *           (2)每个选手一天只能参赛一次；
 *           (3)循环赛在n-1天内结束。
 *           按此要求将比赛日程表设计成有n行和n-1列的一个表。
 *           在表中的第i行，第j列处填入第i个选手在第j天所遇到的选手。
 * @author wonderful
 * @date 2019年10月11日下午7:06:42
 */
public class RoundRobinSchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 k 的值（2^k个运动员）");
        int k = scanner.nextInt();
        scanner.close();
        // 求运动员人数
        int n = 1;
        for (int i = 1; i <= k; i++) {
            n = n * 2;
        }
        // 创建二维数组作为日程表
        int[][] array = new int[n + 1][n + 1];
        // 制作日程表
        table(k, array, n);
        // 输出日程表
        printTable(array, n);
    }

    /**
     *
     * @param k：2^k个运动员
     * @param a：循环赛日程表
     * @param n：运动员的人数
     */
    private static void table(int k, int[][] a, int n) {
        // 设置日程表第一行
        for (int i = 1; i <= n; i++) {
            a[1][i] = i;
        }
        // 每次填充时，起始填充位置
        int m = 1;
        for (int s = 1; s <= k; s++) {
            n /= 2;
            for (int t = 1; t <= n; t++) {
                // 控制行
                for (int i = m + 1; i <= 2 * m; i++) {
                    // 控制列
                    for (int j = m + 1; j <= 2 * m; j++) {
                        // 右下角等于左上角的值
                        a[i][j + (t - 1) * m * 2] = a[i - m][j + (t - 1) * m * 2 - m];
                        // 左下角等于右上角的值
                        a[i][j + (t - 1) * m * 2 - m] = a[i - m][j + (t - 1) * m * 2];
                    }
                }
            }
            m *= 2;
        }
    }

    // 输出日程表
    private static void printTable(int[] array[], int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}