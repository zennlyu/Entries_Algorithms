package com.algorithms.nnu.Divide_Counquer.hanoi;

import java.util.Scanner;

public class Hanoi {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input num: ");
        n = sc.nextInt();
        System.out.println("Process: ");
        move(n, 'A', 'B', 'C');
    }

    /**
     * 圆盘移动
     * @param n 圆盘个数
     * @param a 需要移动的位置
     * @param b 借助的位置
     * @param c 移动目的地
     */
    public static void move(int n, char a, char b, char c) {
        if (n < 0) {
            System.out.println("enter n > 0");
        } else if (n == 1) {
            System.out.println(a + "-->" + c);
        } else {
            move(n - 1, a, c, b);
            move(1, a, b, c);
            move(n-1, b, a, c);
        }
    }
}
