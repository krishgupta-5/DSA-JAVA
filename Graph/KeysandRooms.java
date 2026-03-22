package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class KeysandRooms {
    public static void main(String[] args) {
        int[][] rooms = {{1}, {2}, {3}, {}};
        System.out.println(canVisitAllRooms(rooms));
    }
    
    static boolean canVisitAllRooms(int[][] rooms) {
        int n = rooms.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (queue.size() != 0) {
            int front = queue.remove();
            int[] list = rooms[front];
            for(int j = 0; j < list.length; j = j + 1){
                if(!visited[list[j]]){
                    queue.add(list[j]);
                    visited[list[j]] = true;
                }
            }
        }

        for(boolean bool : visited){
            if(!bool){
                return bool;
            }
        }
        return true;
    }
}
