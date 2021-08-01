package com.algorithms.princeton.BSorting.BasicSort.exercise;


import com.algorithms.princeton.BSorting.BasicSort.Example;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

// 2.1.17
public class SelectionDraw extends Example {

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0; i<N; i++){
            int min=i;
            for(int j=i+1; j<N;j++)
                if(less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void exch(Comparable[] a, int i, int j){

        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

        drawSort(a);
        StdDraw.pause(100);
        StdDraw.clear();
    }
    public static void drawSort(Comparable[] a){
        StdDraw.setXscale(-1, a.length+1);

        Comparable max=a[0];
        for(int i=1;i<a.length;i++) if(less(max, a[i])) max = a[i];
        StdDraw.setYscale(-2, (Integer)max+1);

        for(int i=0;i<a.length;i++){
            int y = (Integer)a[i];
            StdDraw.filledRectangle(i+0.5, y/2.0, 0.3, y/2.0);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N = 100;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        StdRandom.shuffle(a);
        sort(a);
    }
}