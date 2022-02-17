package com.nnu.Greedy.bestloading;

import java.util.Arrays;

/**
 * 最优装载问题（贪心算法）
 * 思想：将集装箱按重量从小到大排序，然后按最轻者优先装入即可
 * @create 2019-12-21 18:35
 */
public class BestLoading {
    //集装箱节点类
    static class Element implements Comparable {
        //重量
        float weight;
        //编号
        int i;

        Element(float weight, int i) {
            this.weight = weight;
            this.i = i;
        }

        @Override
        public int compareTo(Object x) {//按每个重量从小到大排列
            float xx = ((Element) x).weight;
            return Float.compare(this.weight, xx);
        }

        @Override
        public String toString() {
            return "Ele{" +
                    "w=" + weight +
                    ", i=" + i +
                    '}';
        }
    }

    public static float loading(float content, float[] weight) {
        int len = weight.length;
        //初始化集装箱节点   len=4      编号：0~3
        Element[] elements = new Element[len];
        for (int i = 0; i < len; i++) {
            elements[i] = new Element(weight[i], i);
        }
        //按重量排序
        Arrays.sort(elements);

        //已装的最大重量
        float maxLoaded = 0;
        System.out.println("被装载的集装箱编号: ");

        for (int i = 0; i < len && elements[i].weight <= content; i++) {
            maxLoaded += elements[i].weight;
            //输出被装载的编号
            System.out.println(elements[i] + " ");
            //计算剩余可装重量content
            content -= elements[i].weight;
        }
        return maxLoaded;
    }

    public static void main(String[] args) {
        //集装箱重量
        float[] weight = {20, 10, 26, 15, 18};
        //最大装载量
        float content = 70f;
        float loadedContent = loading(content, weight);

        System.out.println("\n轮船载重为："+content);
        System.out.println("最优装载重量为：" + loadedContent);
    }
}