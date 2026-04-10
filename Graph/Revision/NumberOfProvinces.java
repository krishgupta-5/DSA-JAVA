package Graph.Revision;

import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited, isConnected);
                count++;
            }
        }
        return count;
    }

    public void bfs(int i, boolean[] isVisited, int[][] adj) {
        int n = adj.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        isVisited[i] = true;

        while (!q.isEmpty()) {
            int front = q.remove();
            for (int j = 0; j < n; j++) {
                if (adj[front][j] == 1 && !isVisited[j]) {
                    isVisited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}