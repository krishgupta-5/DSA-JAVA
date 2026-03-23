package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1, 0 },
                        { 1, 1, 0, 0 },
                        { 0, 0, 1, 1 }};
        int n = arr.length, m = arr[0].length;
        int[][] ans = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1) q.add(new Pair(i,j));
            }
        }
        while(q.size()>0){
            Pair front = q.remove();
            int row = front.row, col = front.col;
            // left
            if(col-1 >= 0 && arr[row][col-1]==0 && ans[row][col-1]==0){
                ans[row][col-1] = ans[row][col] + 1;
                q.add(new Pair(row,col-1));
            }
            // right
            if(col+1 < n && arr[row][col+1]==0 && ans[row][col+1]==0){
                ans[row][col+1] = ans[row][col] + 1;
                q.add(new Pair(row,col+1));
            }
            // up
            if(row-1 >= 0 && arr[row-1][col]==0 && ans[row-1][col]==0) {
                ans[row-1][col] = ans[row][col] + 1;
                q.add(new Pair(row-1,col));
            }
            // down
            if(row+1 < m && arr[row+1][col]==0 && ans[row+1][col]==0) {
                ans[row+1][col] = ans[row][col] + 1;
                q.add(new Pair(row+1,col));
            }
        }
        ArrayList<ArrayList<Integer>> ans2 = new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> a = new ArrayList<>();
            for(int j=0;j<n;j++){
                a.add(ans[i][j]);
            }
            ans2.add(a);
        }
        System.out.println(ans2);
    }
}
