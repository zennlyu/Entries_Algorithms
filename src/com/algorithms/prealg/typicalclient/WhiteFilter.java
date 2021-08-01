package com.algorithms.prealg.typicalclient;

import edu.princeton.cs.algs4.*;

public class WhiteFilter
{
    public static int search(String key, String[] a)
    {   // Straw man implementation: Sequential search (first try)
        for (int i = 0; i < a.length; i++)
            if (a[i].compareTo(key) == 0)   return i;
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] words = in.readAllStrings();

        while (!StdIn.isEmpty())
        {
            String key = StdIn.readString();
            if (search(key, words) != -1)
                StdOut.println(key);
        }
    }
}