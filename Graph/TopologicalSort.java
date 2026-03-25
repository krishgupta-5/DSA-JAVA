package Graph;
import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 4, E = 3;
        int edges[][] = {{3, 0}, {1, 0}, {2, 0}};
        System.out.println(topoSort(V, edges).toString());

    }
    public static ArrayList<Integer> topoSort(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i = i + 1) {
            list.add(new ArrayList<>());
        }
        
        int []indegree = new int[n];
        for (int i = 0; i < edges.length; i = i + 1) {
            int u = edges[i][0];
            int v = edges[i][1];

            list.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i = i + 1){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(q.size() > 0){
            int vertex = q.remove();
            ans.add(vertex);
            for(int ele : list.get(vertex)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        return ans;
    }
}
