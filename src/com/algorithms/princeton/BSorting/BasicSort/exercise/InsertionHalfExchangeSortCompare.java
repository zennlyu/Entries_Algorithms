package com.algorithms.princeton.BSorting.BasicSort.exercise;


import edu.princeton.cs.algs4.*;

public class InsertionHalfExchangeSortCompare {

    public static double timeRandomInput(String alg, int N, int T) {

        double total = 0.0;

        Double[] a = new Double[N];
        for(int t = 0; t < T; t++) {
            for(int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }

        return total;

    }

    public static double time(String alg, Double[] a) {

        Stopwatch timer = new Stopwatch();

        if(alg.equals("Selection"))
            Selection.sort(a);
        if(alg.equals("Insertion"))
            Insertion.sort(a);
        if(alg.equals("InsertionHalfExchange"))
            InsertionHalfExchange.sort(a);
        if(alg.equals("Shell"))
            Shell.sort(a);

        return timer.elapsedTime();

    }

    public static void main(String[] args) {

        String alg1 = "Insertion";
        String alg2 = "InsertionHalfExchange";
        int N = 1000;
        int T = 1000;

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles %d trials\n", N, T, alg1);
        StdOut.printf("%s is %.1fs %s is %.1fs", alg1, t1, alg2, t2);

    }

}
