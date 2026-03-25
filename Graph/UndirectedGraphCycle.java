package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {
    public static class Pair{
        int vertex;
        int parent;

        Pair(int vertex, int parent){
            this.vertex = vertex;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        int V = 4, E = 4;
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;  i < V; i = i + 1){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i = i + 1){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] vis = new boolean[V];
        for(int i = 0; i < V; i = i + 1){
            if(!vis[i]){
                if(bfs(i, vis, adj)){
                    System.out.println("Cycle Detected!");
                    return;
                }
            }
        }
    }

    private static boolean bfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (q.size() > 0) {
            Pair front = q.remove();
            int vertex = front.vertex;
            int parent = front.parent;
            for(int ele : adj.get(vertex)){
                if(!vis[ele]){
                    q.add(new Pair(ele, vertex));
                    vis[ele] = true;
                }
                else if(ele != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
