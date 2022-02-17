package com.princeton.coursera.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF grid;
    private WeightedQuickUnionUF percGrid;
    private boolean[] openMark;
    private int gridSize;
    private boolean onPercolate = false;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.validateSize(n);
        this.gridSize = n;
        this.grid = new WeightedQuickUnionUF(n*n + 1);
        this.percGrid = new WeightedQuickUnionUF(n*n + 2);
        this.openMark = new boolean[n*n + 2];
        openMark[0] = true;
        openMark[n*n + 1] = true;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.validateIndex(row, col);
        int rowMultiplier = row - 1;
        int index = rowMultiplier * gridSize + col;
        if (!this.openMark[index]) {
            this.openMark[index] = true;
        }

        this.connectToNeighbors(index, row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        this.validateIndex(row, col);
        int index = (row - 1) * this.gridSize + col;
        return this.openMark[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        this.validateIndex(row, col);
        int index = (row - 1) * this.gridSize + col;
        return this.grid.connected(index, 0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        if (!this.onPercolate) {
            this.onPercolate = this.percGrid.connected(0, this.gridSize * this.gridSize + 1);
        }
        return this.onPercolate;
    }

    private void connectToNeighbors(int index, int row, int col) {
        this.validateIndex(row, col);

    }

    private void validateSize(int n) {
        if (n <= 0) {
            throw new java.lang.IllegalArgumentException(
                    "Size of the grid cannot be less than or equal to zero"
            );
        }
    }

    private void validateIndex(int row, int col) {
        if (row < 1 || row > gridSize || col < 1 || col > gridSize) {
            throw new java.lang.IllegalArgumentException(String.format(
                    "Request cell %d %d was out of the grid's bound", row, col)
            );
        }
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
