package com.algorithms.prealg.binarysearch;

public class BinarySearch {
    public static int search(String key, String[] a)
    {  return search(key, a, 0, a.length); }

    public static int search(String key, String[] a, int lo, int hi)
    {
        if (hi <= lo)   return -1;
        int mid = lo + (hi - lo)/2;
        int cmp = a[mid].compareTo(key);
        if      (cmp > 0)   return search(key, a, lo, mid);
        else if (cmp < 0)   return search(key, a, mid+1, hi);
        else                return mid;
    }
}