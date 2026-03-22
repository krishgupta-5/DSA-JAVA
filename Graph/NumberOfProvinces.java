package Graph;
import java.util.*;

public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int n){
        int count = 0;
        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i = i + 1){
            if(!visited[i]){
                bfs(i, visited, adj);
                count = count + 1;
            }
        }
        return count;
    }

    static void bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;  
        while (queue.size() > 0) {
            int front = queue.remove();
            for(int j = 0; j < n; j = j + 1){
                if(adj.get(front).get(j) == 1 && visited[j] == false){
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        list.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        list.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        int result = numProvinces(list, 3);
        System.out.println("Number of provinces: " + result);
    }
}
