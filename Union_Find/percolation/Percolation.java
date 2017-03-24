/*----------------------------------------------------------------
 *  Author:        ChuanleiGuo
 *  Written:       3/24/2017
 *  Last updated:  3/24/2017
 *
 *  Compilation:   javac Percolation.java
 *  Execution:     java Percolation
 *  
 *  Description:  Modeling Percolation using an N-by-N grid and Union-Find data 
 *                structures to determine the threshold. woot. woot.
 *
 *  % java Percolation
 *----------------------------------------------------------------*/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF grids, auxGrids;
    private boolean[] status;
    private int numOfRows;
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Arguments out of bound");
        }
        this.numOfRows = n;
        grids = new WeightedQuickUnionUF(n * n + 2);
        auxGrids = new WeightedQuickUnionUF(n * n + 1);
        status = new boolean[n * n + 2];

        for (int i = 0; i < status.length; i++) {
            status[i] = false;
        }

        status[0] = true;
        status[status.length - 1] = true;
    }

    public void open(int row, int col) {
        int idx = xyToIndex(row, col);
        status[idx] = true;

        if (row != 1 && isOpen(row - 1, col)) {
            grids.union(idx, xyToIndex(row - 1, col));
            auxGrids.union(idx, xyToIndex(row - 1, col));
        }
        if (row != numOfRows && isOpen(row + 1, col)) {
            grids.union(idx, xyToIndex(row + 1, col));
            auxGrids.union(idx, xyToIndex(row + 1, col));
        }
        if (col != 1 && isOpen(row, col - 1)) {
            grids.union(idx, xyToIndex(row, col - 1));
            auxGrids.union(idx, xyToIndex(row, col - 1));
        }
        if (col != numOfRows && isOpen(row, col + 1)) {
            grids.union(idx, xyToIndex(row, col + 1));
            auxGrids.union(idx, xyToIndex(row, col + 1));
        }

        if (isTopSite(idx)) {
            grids.union(0, idx);
            auxGrids.union(0, idx);
        }
        if (isBottemSite(idx)) {
            grids.union(idx, status.length - 1);
        }
    }

    public boolean isOpen(int row, int col) {
        int idx = xyToIndex(row, col);
        return status[idx];
    }

    public boolean isFull(int row, int col) {
        int idx = xyToIndex(row, col);
        return grids.connected(0, idx) && auxGrids.connected(0, idx);
    }

    public int numberOfOpenSites() {
        int total = 0;
        for (int i = 0; i < status.length - 1; i++) {
            if (status[i]) {
                total += 1;
            }
        }
        return total;
    }

    public boolean percolates() {
        return grids.connected(0, status.length - 1);
    }

    private int xyToIndex(int row, int col) {
        if (row <= 0 || row > numOfRows) {
            throw new IndexOutOfBoundsException("row index i out of bounds");
        }
        if (col <= 0 || col > numOfRows) {
            throw new IndexOutOfBoundsException("column j out of bound");
        }
        return (row - 1) * numOfRows + col;
    }

    private boolean isTopSite(int index) {
        return index <= numOfRows;
    }

    private boolean isBottemSite(int index) {
        return index >= (numOfRows - 1) * numOfRows + 1;
    }

    public static void main(String[] args) {
        
    }
}