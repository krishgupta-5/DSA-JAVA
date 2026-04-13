package Graph.Revision;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        for(int i = 0; i < n; i = i + 1){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];

        for(int i = 0; i < n; i = i + 1){
            int u = graph[i][0];
            int v = graph[i][1];

            adj.get(u).add(v);
            indegree[i] ++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < indegree.length; i = i + 1){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();

            res.add(front);

            for(int i = 0; i < adj.get(i).size(); i = i + 1){
                indegree[adj.get(front).get(i)] --;
                if(indegree[adj.get(front).get(i)] == 0){
                    q.add(adj.get(front).get(i));
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}