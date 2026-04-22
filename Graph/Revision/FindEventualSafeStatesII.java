import java.util.*;

class Solution {
    public ArrayList<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < graph.length; i = i + 1){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[graph.length];
        for(int i = 0; i < graph.length; i = i + 1){
            for(int ele : graph[i]){
                indegree[ele]++;
                adj.get(ele).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < graph.length; i = i + 1){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int front = q.remove();
            res.add(front);

            for(int i = 0; i < adj.get(front).size(); i = i + 1){
                indegree[adj.get(front).get(i)]--;
                if(indegree[adj.get(front).get(i)] == 0){
                    q.add(i);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}