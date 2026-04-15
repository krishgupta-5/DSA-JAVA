package Graph.Revision;

import java.util.PriorityQueue;

class Solution {
    public class Triplet{
        int node;
        int parent;
        int dist;

        Triplet(int node, int parent, int dist){
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }

        public int compareTo(Triplet t){
            if(this.dist == t.dist) 
                return Integer.compare(this.node, t.node);
            return Integer.compare(this.dist, t.dist);
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, -1,0));
        int sum = 0;

        boolean vis[] = new boolean[n];
        vis[0] = true;
        while(pq.size() > 0){
            Triplet top = pq.remove();
            int node = top.node, dist = top.dist, parent = top.parent;
            sum += dist;
            vis[node] = true;
            for(int i = 0; i < n; i = i + 1){
                if(i == node){
                    continue;
                }
                if(vis[i]){
                    continue;
                }
                int x1 = points[node][0], x2 = points[node][1];
                int y1 = points[i][0], y2 = points[i][1];

                int mDis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                pq.add(new Triplet(i, node, mDis));
            }
        }

        return 0;
    }
}