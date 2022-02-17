package com.algorithms.princeton.BSorting.ElementarySort.exercise;

// 2.1.16
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
public class ValidationSortingUnchanged
{
    public static void sort(Comparable[] a)
    { }

    private static boolean less(Comparable v,Comparable w)
    { return v.compareTo(w)<0;}

    private static void exch(Comparable[] a,int i,int j)
    {
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static void show(Comparable[] a)
    {
        for (int i=0;i<a.length;i++)
            StdOut.print(a[i]+" ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for (int i=0;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static boolean check(Comparable[] a)
    {
        //create a clone array of a
        Comparable[] aClone=new Comparable[a.length];
        for(int i=0;i<a.length;i++)
            aClone[i]=a[i];
        //sort a
        sort(a);
        //sort aClone
        Arrays.sort(aClone);
        //compare array a and aClone
        for(int i=0;i<a.length;i++)
            if (a[i] !=aClone[i]) return false;
        return true;
    }

    public static void main(String[] args) {
    }
}