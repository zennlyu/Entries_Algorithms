package com.nnu.Divide_Counquer.interger_division;

public class IntegerDivision2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //分别用正整数3和正整数6进行用例测试
        int num1 = 3;
        int num2 = 6;

        System.out.println("整数3的划分数为 : " + dividePrintln(3));
        System.out.println("整数6的划分数为 : " + dividePrintln(6));
    }

    public static int integerDivide(int n, int m){
        // n 和 m 为非正整数  返回0
        if(n < 1 || m < 1) {
            return 0;
        } else if(m == 1 || n == 1){        //对应情况为：q（n，1） = 1，n > = 1,q（1，m） = 1
            return 1;
        } else if(m > n){		        //对应情况为：q（n，m）= q（n，n），m  >=  n；
            return integerDivide(n, n);
        } else if(n == m){	    		//对应情况为：q（n，n）= 1 + q（n，n - 1）
            return 1 + integerDivide(n, n - 1);
        } else {				  //对应情况为：q（n，m）= q（n，m - 1）+q（n - m，m - 1）
            return integerDivide(n, m - 1) + integerDivide(n - m, m);
        }
    }

    //中间函数，对给定需要进行划分的正整数调用integerDivide函数。
    public static int dividePrintln(int num){
        return integerDivide(num,num);
    }
}
