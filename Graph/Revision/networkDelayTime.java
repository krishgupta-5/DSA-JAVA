package Graph.Revision;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class networkDelayTime {
    class Pair{
        int node;
        int time;

        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTimeMain(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i = i + 1) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i = i + 1) {
            int u = times[i][0];
            int v = times[i][1];
            int t = times[i][2];

            adj.get(u).add(new Pair(v, t));
        }

        int res[] = new int[n + 1];

        for (int i = 0; i <= n; i = i + 1) {
            res[i] = Integer.MAX_VALUE;
        }

        res[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();

            int node = pair.node;
            int time = pair.time;

            for (Pair p : adj.get(node)) {
                int totalTime = pair.time + p.time;
                if (totalTime < res[p.node]) {
                    res[p.node] = totalTime;
                    pq.add(new Pair(p.node, totalTime));
                }
            }
        }

        int max = -1;
        for (int i = 1; i < res.length; i = i + 1) {
            if (res[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, res[i]);
        }

        return max;
    }
}
