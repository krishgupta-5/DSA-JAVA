package Graph.Revision;

import java.util.*;

class Pair {
    int i;
    int j;
    int effort;

    Pair(int i, int j, int effort) {
        this.i = i;
        this.j = j;
        this.effort = effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int res[][] = new int[m][n];
        for (int row[] : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.effort - b.effort);

        pq.add(new Pair(0, 0, 0));
        res[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            int row = pair.i;
            int col = pair.j;
            int effort = pair.effort;

            if (row == m - 1 && col == n - 1) {
                return effort;
            }
            // left
            if (col - 1 >= 0) {
                int diff = Math.abs(heights[row][col] - heights[row][col - 1]);
                int newEffort = Math.max(diff, effort);
                if (newEffort < res[row][col - 1]) {
                    res[row][col - 1] = newEffort;
                    pq.add(new Pair(row, col - 1, newEffort));
                }
            }
            // right
            if (col + 1 < n) {
                int diff = Math.abs(heights[row][col] - heights[row][col + 1]);
                int newEffort = Math.max(diff, effort);
                if (newEffort < res[row][col + 1]) {
                    res[row][col + 1] = newEffort;
                    pq.add(new Pair(row, col + 1, newEffort));
                }
            }
            // up
            if (row - 1 >= 0) {
                int diff = Math.abs(heights[row][col] - heights[row - 1][col]);
                int newEffort = Math.max(diff, effort);
                if (newEffort < res[row - 1][col]) {
                    res[row - 1][col] = newEffort;
                    pq.add(new Pair(row - 1, col, newEffort));
                }
            }
            // down
            if (row + 1 < m) {
                int diff = Math.abs(heights[row][col] - heights[row + 1][col]);
                int newEffort = Math.max(diff, effort);
                if (newEffort < res[row + 1][col]) {
                    res[row + 1][col] = newEffort;
                    pq.add(new Pair(row + 1, col, newEffort));
                }
            }
        }
        return 0;
    }
}