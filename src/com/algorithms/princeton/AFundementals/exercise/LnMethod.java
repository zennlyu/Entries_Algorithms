package com.algorithms.princeton.AFundementals.exercise;

// 1.1.20 编写一个递归的静态方法计算 ln(N!) 的值
import edu.princeton.cs.algs4.StdOut;

public class LnMethod {
    public static double iterate(int N) {
        double sum = 0;
        if (N == 0) return 0;
        if (N > 0) {
            sum += Math.log(N) + iterate(N - 1);
        }
        return sum;

    }

    public static void main(String[] args) {
        double result = iterate(10);
        StdOut.printf("Result: %.2f", result);
    }
}
