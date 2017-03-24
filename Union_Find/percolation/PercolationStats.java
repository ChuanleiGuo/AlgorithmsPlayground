/*----------------------------------------------------------------
 *  Name:    Chuanlei Guo
 *  NetID:   Chuanlei Guo
 *  Precept: P01
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 * 
 *  Description:  Modeling Percolation using an N-by-N grid and Union-Find data 
 *                structures to determine the threshold. woot. woot.
 *----------------------------------------------------------------*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    private double[] threshold;

    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Argument out of bound");
        }

        threshold = new double[trials];

        int openCount = 0;
        for (int i = 0; i < trials; i++) {
            Percolation pl = new Percolation(n);
            while (!pl.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (pl.isOpen(row, col)) {
                    continue;
                }
                pl.open(row, col);
                openCount += 1;
            }

            threshold[i] = (double) openCount / (n * n);
            openCount = 0;
        }
    }

    public double mean() {
        return StdStats.mean(threshold);
    }

    public double stddev() {
        return StdStats.stddev(threshold);
    }

    public double confidenceLo() {
        return mean() - halfInterval();
    }

    public double confidenceHi() {
        return mean() + halfInterval();
    }

    private double halfInterval() {
        return 1.96 * stddev() / Math.sqrt(threshold.length);
    }

    public static void main(String[] args) {
        PercolationStats pls = new PercolationStats(
            Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.printf("mean                     = %f\n", pls.mean());
        System.out.printf("stddev                   = %f\n", pls.stddev());
        System.out.printf("95%% confidence Interval = %f, %f\n",
                pls.confidenceLo(), pls.confidenceHi());
    }
}