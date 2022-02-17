package com.algorithms.princeton.assignments;

import edu.princeton.cs.algs4.StdIn;

public class HelloGoodbye {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.print("Hello ");
        System.out.print(args[0]);
        System.out.print(" and ");
        System.out.println(args[1] + '.');
        System.out.print("Goodbye ");
        System.out.print(args[1]);
        System.out.print(" and ");
        System.out.println(args[0] + '.');
    }
}