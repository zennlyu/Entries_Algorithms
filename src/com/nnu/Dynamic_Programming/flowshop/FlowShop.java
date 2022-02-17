package com.nnu.Dynamic_Programming.flowshop;

public class FlowShop {
    public int[] a;
    public int[] b;
    public int[] c;

    public FlowShop(int[] aa, int[] bb) {
        this.a = aa;
        this.b = bb;
        this.c = new int[aa.length];
    }

    private static class Element implements Comparable {
        int key;
        int index;
        boolean job;

        public Element(int kk, int ii, boolean jobs) {
            key = kk;
            index = ii;
            job = jobs;
        }

        @Override//根据key值进行排序（升序）
        public int compareTo(Object arg0) {
            int keys = ((Element) arg0).key;
            if (key < keys) return -1;
            if (key == keys) return 0;
            return 1;
        }
    }

    public int flowShop(int[] a, int[] b, int[] c) {
        int n = a.length;
        Element[] d = new Element[n];
        for (int i = 0; i < n; i++) {
            int key = a[i] > b[i] ? b[i] : a[i];//按Johnson法则分别取对应的b[i]或a[i]值作为关键字
            boolean job = a[i] <= b[i];//给符合条件a[i]<b[i]的放入到N1子集标记为true
            d[i] = new Element(key, i, job);
        }
        java.util.Arrays.sort(d);//对数组d按关键字升序进行排序
        int j = 0;
        int k = n - 1;
        for (int i = 0; i < n; i++) {
            if (d[i].job)
                c[j++] = d[i].index;//将排过序的数组d，取其中作业序号属于N1的从前面进入（d[i].index保存的作业序号0，1，2，等等）
            else
                c[k--] = d[i].index;//属于N2的从后面进入，从而实现N1的非减序排序，N2的非增序排序
        }
        j = a[c[0]];
        k = j + b[c[0]];//对于第一个任务，j为M1执行第一个任务的时间，k为M1+M2执行第一个任务的时间，即第一个任务在M1，M2上都执行完的时间
        for (int i = 1; i < n; i++) {
            j += a[c[i]];//M1在执行c[i]作业的同时，M2在执行c[i-1]号作业，最短执行时间取决于M1与M2谁后执行完
            k = j < k ? k + b[c[i]] : j + b[c[i]];//计算最优加工时间
        }
        System.out.println("作业调度的顺序为(编号从0开始)：");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + "  ");
        }
        System.out.println();
        return k;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 1};
        int[] b = {5, 2, 3, 1, 7};
        FlowShop j = new FlowShop(a, b);
        int k = j.flowShop(j.a, j.b, j.c);
        System.out.println("完成作业的最短时间为:" + k);
    }
}