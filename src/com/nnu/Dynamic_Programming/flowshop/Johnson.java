package com.nnu.Dynamic_Programming.flowshop;

import java.util.Arrays;

//主要是Johnson法则的理解，代码很简单
public class Johnson {
    public static int flowShop(int a[],int b[],int c[])
    {
        int n = a.length-1;

        Element d[] = new Element[n];
        for(int i=0;i<n;i++){
            int key=a[i]>b[i]? b[i]:a[i];//找作业在两台机器上处理时间最小的那个作业处理时间
            boolean job = a[i]<=b[i];
            d[i]=new Element(key,i,job);
        }
        Arrays.sort(d);//将所有作业的key进行从小到大排序
        int j=0; int k = n-1;
        //将作业按照Johnson法则排序放入c中
        for(int i=0;i<n;i++){
            if(d[i].job) c[j++]=d[i].index;//如果ai<=bi,将其作业序号放入c数组中（从头开始放）
            else c[k--]=d[i].index;//否则
        }
        //真正的动态规划部分！
        j=a[c[0]];//第一个作业在M1上的处理时间
        k=j+b[c[0]];//第一个作业处理完所需时间
        for(int i=1;i<n;i++){
            j+=a[c[i]];//第i个作业在机器上加工完成所需时间
            k=j<k? k+b[c[i]]:j+b[c[i]];/*如果此作业在M1上加工完成时间
			(包含前面作业在M1上的所用时间和)小于上一个作业全部完成时间（还得等M2做完），则此作业所需时间
			为k+b[c[i]]，否则为j+b[c[i]]*/

        }
        return k;
    }
    public static class Element{
        public int key;
        public	int index;
        public	boolean job;

        private Element(int kk,int ii,boolean jj)
        {
            key=kk;
            index=ii;
            job=jj;
        }
    }
}