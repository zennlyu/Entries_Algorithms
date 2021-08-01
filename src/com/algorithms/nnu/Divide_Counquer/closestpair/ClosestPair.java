package com.algorithms.nnu.Divide_Counquer.closestpair;

import javax.swing.JOptionPane;

public class ClosestPair {
    //合并排序算法
    //定义要排序的的数组
    public static class MergeSort {
        //排序算法
        public static void mergeSort(Comparable a[]) {
            Comparable b[] = new Comparable[a.length];
            int s = 1;
            while (s < a.length) {
                mergePass(a, b, s);//合并到数组b
                s += s;
                mergePass(b, a, s);//合并到数组a
                s += s;
            }
        }

        //合并大小为s的相邻子数组
        public static void mergePass(Comparable x[], Comparable y[], int s) {
            int i = 0;
            while (i <= x.length - 2 * s) {
                //合并大小为s的相邻2段子数组
                merge(x, y, i, i + s - 1, i + 2 * s - 1);
                i = i + 2 * s;
            }
            if (i + s < x.length)
                merge(x, y, i, i + s - 1, x.length - 1);
            else
                //复制到y
                for (int j = i; j < x.length; j++)
                    y[j] = x[j];
        }

        public static void merge(Comparable c[], Comparable d[], int l, int m, int r) {
            //合并 c[l:m]和c[m+1:r]到d[l:r]
            int i = l, j = m + 1, k = l;
            while ((i <= m) && (j <= r))
                if (c[i].compareTo(c[j]) <= 0) {
                    d[k++] = c[i++];
                } else
                    d[k++] = c[j++];
            if (i > m)
                for (int q = j; q <= r; q++)
                    d[k++] = c[q];
            else
                for (int q = i; q <= m; q++)
                    d[k++] = c[q];
        }
    }

    public static class Point {
        double x, y;

        public Point(double xx, double yy) {
            x = xx;
            y = yy;
        }
    }

    public static class Point1 extends Point implements Comparable {
        int id;

        public Point1(double xx, double yy, int theID) {
            super(xx, yy);
            id = theID;
        }

        public int compareTo(Object x) {
            double xx = ((Point1) x).x;
            if (this.x < xx)
                return -1;
            if (this.x == xx)
                return 0;
            return 1;
        }

        public boolean equals(Object x) {
            return this.x == ((Point1) x).x;
        }

        public void getID() {
            System.out.println(id);
        }
    }

    public static class Point2 extends Point implements Comparable {
        int p;

        public Point2(double xx, double yy, int pp) {
            super(xx, yy);
            p = pp;
        }

        public int compareTo(Object x) {
            double xy = ((Point2) x).y;
            if (this.y < xy)
                return -1;
            if (this.y == xy)
                return 0;
            return 1;
        }

        public boolean equals(Object x) {
            return this.y == ((Point2) x).y;
        }

        //输出点的序号
        public void getp() {
            System.out.println(p);
        }
    }

    public static class Pair {
        Point1 a;
        Point1 b;
        double dist;

        public Pair(Point1 aa, Point1 bb, double dd) {
            a = aa;
            b = bb;
            dist = dd;
        }

        public void print() {
            System.out.println("输出点a的序号：");
            a.getID();
            System.out.println("输出点b的序号：");
            b.getID();
            System.out.println("输出两点之间的距离:");
            System.out.println(dist);
        }
    }

    public static double dist(Point u, Point v) {
        double dx = u.x - v.x;
        double dy = u.y - v.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Pair cpair2(Point1 x[]) {
        if (x.length < 2)
            return null;
        MergeSort.mergeSort(x);
        Point2 y[] = new Point2[x.length];
        for (int i = 0; i < x.length; i++)
            //将数组中x中的点复制到数组y中
            y[i] = new Point2(x[i].x, x[i].y, i);
        MergeSort.mergeSort(y);//依y排序
        Point2 z[] = new Point2[x.length];
        //计算最近点对
        return closestPair(x, y, z, 0, x.length - 1);
    }

    private static Pair closestPair(Point1 x[], Point2 y[], Point2 z[], int l, int r) {
        if (r - l == 1)//2点的情形
            return new Pair(x[l], x[r], dist(x[l], x[r]));
        if (r - l == 2) {
            //三点的情形
            double d1 = dist(x[l], x[l + 1]);
            double d2 = dist(x[l + 1], x[r]);
            double d3 = dist(x[l], x[r]);
            if (d1 <= d2 && d1 <= d3)
                return new Pair(x[l], x[l + 1], d1);
            if (d2 <= d3)
                return new Pair(x[l + 1], x[r], d2);
            else
                return new Pair(x[l], x[r], d3);
        }
        //多于3点的情形，用分治法
        int m = (l + r) / 2;
        int f = l, g = m + 1;
        for (int i = l; i <= r; i++)
            if (y[i].p > m)
                z[g++] = y[i];
            else z[f++] = y[i];
        //递归求解
        Pair best = closestPair(x, z, y, l, m);
        Pair right = closestPair(x, z, y, m + 1, r);
        if (right.dist < best.dist)
            best = right;
        MergeSort.merge(z, y, l, m, r);//重构数组y
        //d矩形条内的点置于z中
        int k = l;
        for (int i = l; i <= r; i++)
            if (Math.abs(x[m].x - y[i].x) < best.dist)
                z[k++] = y[i];
        //搜索z[l:k-1]
        for (int i = l; i < k; i++) {
            for (int j = i + 1; j < k && z[j].y - z[i].y < best.dist; j++) {
                double dp = dist(z[i], z[j]);
                if (dp < best.dist)
                    best = new Pair(x[z[i].p], x[z[j].p], dp);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String m = JOptionPane.showInputDialog(null, "输入点的个数：", "最接近点问题", JOptionPane.QUESTION_MESSAGE);
        int n = Integer.parseInt(m);
        Point1 p[] = new Point1[n];
        for (int i = 0; i < n; i++) {
            String s1 = JOptionPane.showInputDialog(null, "输入p[" + i + "]的横坐标", "最接近点问题", JOptionPane.QUESTION_MESSAGE);
            int x = Integer.parseInt(s1);
            String s2 = JOptionPane.showInputDialog(null, "输入p[" + i + "]的纵坐标",
                    "最接近点问题", JOptionPane.QUESTION_MESSAGE);
            int y = Integer.parseInt(s2);
            p[i] = new Point1(x, y, i);
        }
        Pair pair = cpair2(p);
        pair.print();
    }
}