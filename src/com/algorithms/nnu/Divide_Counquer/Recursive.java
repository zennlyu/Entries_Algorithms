package com.algorithms.nnu.Divide_Counquer;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.Stack;

public class Recursive {                            // 递归算法整合
    public static int factorial(int n) {            // 阶乘算法
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {            // Fibonacci 算法
        if (n <= 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int ackerman(int m, int n) {             //m,n分别为 ackerman 的两个参数
        Stack<Integer> s1 = new Stack<Integer>();   //用栈来存储参数，s1存m,s2存n
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(m);
        s2.push(n);
        while (!s1.isEmpty()) {                     //s1 为空时计算结束，s2 此时存了结果
            int i = s1.pop();                       //i,j 分别存入 s1，s2 的栈顶，首次执行 while 循环存入的是 m，n 的值
            int j = s2.pop();
            if (i == 0) {                           //if-elseif-elseif 分别对应三种情况
                s2.push(j + 1);
            } else if (i != 0 && j == 0) {
                s1.push(i-1);
                s2.push(1);
            } else if(i!=0 && j!=0){
                s1.push(i-1);
                s1.push(i);
                s2.push(j-1);
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        ackerman(5,6);
    }
}