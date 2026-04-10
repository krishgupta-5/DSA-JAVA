package Graph.Revision;

import java.util.*;

public class undirectedGraphCycle {
    public static class Pair{
        int vertex;
        int parent;

        Pair(int vertex, int parent){
            this.vertex = vertex;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < V; i = i + 1){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i = i + 1){
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i = i + 1){
            if(!vis[i]){
                if(dfs(i, -1, vis, list)){
                    System.out.println(true);
                }
            }
        }
        System.out.println(false);
    }
    public static boolean dfs(int i, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> list) {
        vis[i] = true;
        for(int j = 0; j < list.get(i).size(); j = j + 1){
            int ele = list.get(i).get(j);
            if(!vis[ele]){
                if(dfs(ele, i, vis, list)){
                    return true;
                }
            }
            else if(ele != parent){
                return true;
            }
        }
        return false;
    }
}
