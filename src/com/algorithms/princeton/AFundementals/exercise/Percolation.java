package com.algorithms.princeton.AFundementals.exercise;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int count;          				// number of open sites
    private boolean[] isOpenSite;
    private final int n;
    private final int vTop;           			// the virtual top node
    private final int vBottom;       			// the virtual bottom node
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufBW;    // to avoid backwash

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        count = 0;
        this.n = n;
        vTop = 0;
        vBottom = n * n + 1;
        isOpenSite = new boolean[n * n + 2];
        uf = new WeightedQuickUnionUF(n * n + 2);
        ufBW = new WeightedQuickUnionUF(n * n + 2);
        isOpenSite[vTop] = true;
        isOpenSite[vBottom] = true;
    }


    public boolean isOpen(int row, int col) {
        check(row, col);
        return isOpenSite[toIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        check(row, col);
        return ufBW.connected(vTop, toIndex(row, col));
    }

    public boolean percolates() {
        return uf.connected(vTop, vBottom);
    }

    public int numberOfOpenSites() {
        return count;
    }

    public void open(int row, int col) {
        check(row, col);
        int index = toIndex(row, col);
        if (isOpenSite[index]) {
            return;
        }

        isOpenSite[index] = true;
        // connect the node in the first row with the virtual top node
        if (row == 1) {
            uf.union(index, vTop);
            ufBW.union(index, vTop);
        }
        // connect the node in the last row with the virtual bottom node
        if (row == n) {
            uf.union(index, vBottom);
        }
        // union up
        if (row >= 2 && isOpenSite[index - n]) {
            uf.union(index, index - n);
            ufBW.union(index, index - n);
        }
        // union down
        if (row < n && isOpenSite[index + n]) {
            uf.union(index, index + n);
            ufBW.union(index, index + n);
        }
        // union left
        if (col >= 2 && isOpenSite[index - 1]) {
            uf.union(index, index - 1);
            ufBW.union(index, index - 1);
        }
        // union right
        if (col < n && isOpenSite[index + 1]) {
            uf.union(index, index + 1);
            ufBW.union(index, index + 1);

        }
        count++;
    }

    // change coordinate to index
    private int toIndex(int i, int j) {
        return (i - 1) * n + j;
    }

    // check if the coordinate is valid
    private void check(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {

    }
}