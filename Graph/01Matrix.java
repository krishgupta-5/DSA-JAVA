package Graph;
import java.util.*;

class Solution {
    class Triplet{
        int i;
        int j;
        int dis;

        Triplet(int i, int j, int dis){
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean vis[][] = new boolean[m][n];
        int dis[][] = new int[m][n];

        Queue<Triplet> q = new LinkedList<>();
        for(int i = 0; i < m; i = i + 1){
            for(int j = 0; j < n; j = j + 1){
                if(mat[i][j] == 0){
                    vis[i][j] = true;
                    q.add(new Triplet(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            Triplet front = q.remove();
            int i = front.i;
            int j = front.j;
            int distance = front.dis;

            dis[i][j] = distance;

            if(i - 1 > 0){
                if(mat[i - 1][j] == 1 && vis[i - 1][j] == false){
                    vis[i - 1][j] = true;
                    q.add(new Triplet(i - 1, j, distance + 1));
                }
            }
            if(i + 1 < m){
                if(mat[i + 1][j] == 1 && vis[i + 1][j] == false){
                    vis[i + 1][j] = true;
                    q.add(new Triplet(i + 1, j, distance + 1));
                }
            }
            if(j - 1 > 0){
                if(mat[i][j  - 1] == 1 && vis[i][j - 1] == false){
                    vis[i][j - 1] = true;
                    q.add(new Triplet(i, j - 1, distance + 1));
                }
            }
            if(j + 1 < n){
                if(mat[i][j + 1] == 1 && vis[i][j + 1] == false){
                    vis[i][j + 1] = true;
                    q.add(new Triplet(i, j + 1, distance + 1));
                }
            }
        }

        return dis;
    }
}