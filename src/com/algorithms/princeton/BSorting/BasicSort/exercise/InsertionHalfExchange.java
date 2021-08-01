package com.algorithms.princeton.BSorting.BasicSort.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InsertionHalfExchange {

    public static void sort(Comparable[] a) {

        int N = a.length;

        for(int i = 1; i < N; i++) {
            Comparable temp = a[i];
            int j = i;
            while(j > 0 && less(temp, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
//            show(a);
        }

    }

    private static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;

    }

    private static void exch(Comparable[] a, int i, int j) {

        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;

    }

    private static void show(Comparable[] a) {

        //print the array, on a single line.
        for(int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

    }

    public static boolean isSorted(Comparable[] a) {

        for(int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        //Read strings from standard input, sort them, and print.
        String[] a = In.readStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}