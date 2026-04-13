package Graph.Revision;

import java.util.*;

class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> topoSort1(int V, int[][] edges) {
        res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i = i + 1){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i = i + 1){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i = i + 1){
            if(!vis[i]){
                dfs(i, vis, adj);
            }
        }
        int start = 0, end = res.size();

        return res;
        
    }
    public void dfs(int i, boolean vis[],  ArrayList<ArrayList<Integer>> adj){
        vis[i] = true;

        for(int j = 0; j < adj.get(i).size(); j = j + 1){
            dfs(adj.get(i).get(j), vis, adj);
        }

        res.add(i);
    }


    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i = i + 1){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[V];

        for(int i = 0; i < edges.length; i = i + 1){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            indegree[v] ++;
        }
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i = i + 1){
            if(indegree[i] == 0){
                vis[i] = true;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int front = q.remove();
            res.add(front);
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        return res;
    }
}