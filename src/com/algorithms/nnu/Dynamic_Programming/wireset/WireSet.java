package com.algorithms.nnu.Dynamic_Programming.wireset;

import java.util.Arrays;

/**
 * 动态规划电路布线问题
 * @author ruochen
 * @version 1.0
 */

public class WireSet {

    private static int size[][];
    private static final int[] C = {0, 9, 7, 4, 2, 5, 1, 9, 3, 10, 6};
    private static final int num = 10;

    public static void main(String[] args) {
        int NET[] = new int[9];
        MNS(C, 10);
        Traceback(C, 10, NET);
        System.out.println(Arrays.toString(NET));
    }

    /**
     *
     * @param C 导线上下接线柱对应的关系
     * @param n 导线数量
     */
    public static void MNS(int[] C, int n) {
        int i, j;
        size = new int[num + 1][num + 1];

        // 判断第一行， i = 1 的情况
        for (j = 0; j < C[1]; j++) {
            size[1][j] = 0;
        }
        for (j = C[1]; j <= n; j++) {
            size[1][j] = 1;
        }

        // 2->n 的情况
        for (i = 2; i < n; i++) {
            for (j = 0; j < C[i]; j++) {
                // i > 1 && j < Π(i) 的情况
                size[i][j] = size[i-1][j];
            }
            for (j = C[i]; j <= n; j++) {
                size[i][j] = Math.max(size[i-1][j], size[i-1][C[i]-1] + 1);
            }
        }
        size[n][n] = Math.max(size[n-1][n], size[n-1][C[n]-1] + 1);
    }

    /**
     * 获得一个记录可连接导线的数组
     * @param C 导线上下两接线柱对应的关系
     * @param n 导线数量
     * @param NET 记录可连接的导线
     */
    public static void Traceback(int[] C, int n, int NET[]) {
        int i, j = n;
        int m = 0;
        for (i = n; i > 1; i--) {
            if (size[i][j] != size[i-1][j]) {
                NET[m++] = i;
                j = C[i] - 1;
            }
            // 第一条线
            if (j >= C[1]) {
                NET[m++] = 1;
            }
        }
    }

}