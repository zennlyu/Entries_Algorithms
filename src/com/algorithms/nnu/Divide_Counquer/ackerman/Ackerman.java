package com.algorithms.nnu.Divide_Counquer.ackerman;

import java.util.Scanner;
import java.util.Stack;

public class Ackerman {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        System.out.println(Ackerman2(n, m));
    }
    public static int Ackerman1(int n,int m){
        if(n==0 && m>=0)return 1;
        if(n==1 && m==0)return 2;
        if(n>=2 && m==0)return n+2;
        if(n>=1 && m>=1)
            return Ackerman1(Ackerman1(n-1,m),m-1);
        return -1;
    }
    public static int Ackerman2(int m, int n) {             //m,n分别为 ackerman 的两个参数
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
}