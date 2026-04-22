import java.util.*;

class Solution {
    public class Triplet{
        int row;
        int col;
        int time;
        Triplet(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        Queue<Triplet> q = new LinkedList<>();

        // First Store the rotten oranges

        for(int i = 0; i < m; i = i + 1){
            for(int j = 0; j < n; j = j + 1){
                if(grid[i][j] == 2){
                    q.add(new Triplet(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            Triplet vertex = q.remove();
            int row = vertex.row;
            int col = vertex.col;
            int time = vertex.time;

            max = Math.max(max, time);

            if(row - 1 >= 0 && grid[row - 1][col] == 1){
                grid[row - 1][col] = 2;
                q.add(new Triplet(row - 1, col, time + 1));
            }
            if(row + 1 < m && grid[row + 1][col] == 1){
                grid[row + 1][col] = 2;
                q.add(new Triplet(row + 1, col, time + 1));
            }
            if(col - 1 >= 0 && grid[row][col - 1] == 1){
                grid[row][col - 1] = 2;
                q.add(new Triplet(row, col - 1, time + 1));
            }
            if(col + 1 < n && grid[row][col + 1] == 1){
                grid[row][col + 1] = 2;
                q.add(new Triplet(row, col + 1, time + 1));
            }
        }

        for(int i = 0; i < m; i = i + 1){
            for(int j = 0; j < n; j = j + 1){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return max;
    }
}