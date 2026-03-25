package Graph;

import java.util.*;

public class BipartiteGraph {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < V; i = i + 1) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i = i + 1) {
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        // System.out.println(isBipartite(V, edges));
        System.out.println(isBipartite(V, list));
    }
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int[] vis = new int[V]; // 0 = unvisited, 1 & 2 = colors
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(!bfs(i, vis, adj)){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean bfs(int src, int []vis, ArrayList<ArrayList<Integer>> adj){
        vis[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(q.size() > 0){
            int vertex = q.remove();
            int color = vis[vertex];

            for(int ele : adj.get(vertex)){
                if(vis[ele] == 0){
                    q.add(ele);
                    vis[ele] = 3 - color;
                }
                else if(vis[ele] == color){
                    return false;
                }
            }
        }
        return true;
    }

    // public static boolean isBipartite(int V, int[][] edges) {
    //     int[] color = new int[V];
    //     for (int i = 0; i < V; i = i + 1) {
    //         color[i] = -1;
    //     }

    //     ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    //     for (int i = 0; i < V; i = i + 1) {
    //         list.add(new ArrayList<>());
    //     }

    //     for (int i = 0; i < edges.length; i = i + 1) {
    //         int u = edges[i][0];
    //         int v = edges[i][1];

    //         list.get(u).add(v);
    //         list.get(v).add(u);
    //     }

    //     for (int i = 0; i < V; i = i + 1) {
    //         if (color[i] == -1) {
    //             Queue<Integer> q = new LinkedList<>();
    //             color[i] = 0;
    //             q.add(i);

    //             while (!q.isEmpty()) {
    //                 int front = q.remove();

    //                 for (int ele : list.get(front)) {
    //                     if (color[ele] == -1) {
    //                         color[ele] = 1 - color[front];
    //                         q.add(ele);
    //                     } 
    //                     else if (color[ele] == color[front]) {
    //                         return false;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
}
