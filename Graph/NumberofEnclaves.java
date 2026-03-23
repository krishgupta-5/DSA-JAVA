package Graph;
import java.util.*;
public class NumberofEnclaves {
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0}};
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        for(int j = 0; j < n; j = j + 1){
            if(grid[0][j] == 1){
                grid[0][j] = -1;
                q.add(new Pair(0, j));
            }
            if(grid[m-1][j] == 1){
                grid[m-1][j] = -1;
                q.add(new Pair(m-1, j));
            }
        }
        for(int i = 0; i < m; i = i + 1){
            if(grid[i][0] == 1){
                grid[i][0] = -1;
                q.add(new Pair(i, 0));
            }
            if(grid[i][n-1] == 1){
                grid[i][n-1] = -1;
                q.add(new Pair(i, n - 1));
            }
        }

        while (!q.isEmpty()) {
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;


            // UP
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = -1;
                q.add(new Pair(row - 1, col));
            }

            // DOWN
            if (row + 1 < m && grid[row + 1][col] == 1) {
                grid[row + 1][col] = -1;
                q.add(new Pair(row + 1, col));
            }

            // LEFT
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = -1;
                q.add(new Pair(row, col - 1));
            }

            // RIGHT
            if (col + 1 < n && grid[row][col + 1] == 1) {
                grid[row][col + 1] = -1;
                q.add(new Pair(row, col + 1));
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count = count + 1;
                }
            }
        }
        System.out.println(count);
    }
}