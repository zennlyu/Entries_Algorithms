package com.algorithms.prealg.typicalclient;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestSS {
    public static int search(String key, String[] a)
    {   // Straw man implementation: Sequential search (first try)
        for (int i = 0; i < a.length; i++)
            if (a[i].compareTo(key) == 0)   return i;
        return -1;
    }

    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        int N = words.length;
        double start = System.currentTimeMillis()/1000.0;
        for (int i = 0; i < 10*N; i++)
        {
            String key = words[StdRandom.uniform(N)];
            if (search(key, words) == -1)
                StdOut.println(key);
        }
        double now = System.currentTimeMillis()/1000.0;
        StdOut.println(Math.round(now-start) + " seconds");
    }
}
