import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i = i + 1){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[V];

        for(int i = 0; i < edges.length; i = i + 1){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i = i + 1){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        while (!q.isEmpty()) {
            int front = q.remove();
            res.add(front);

            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }

        return V != res.size();
    }
}