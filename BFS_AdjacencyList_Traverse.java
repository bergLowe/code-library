import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>(V);
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        queue.offerLast(0);
        visited[0] = true;
        list.add(0);

        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();

            for (int v: adj.get(vertex)) {
                if (!visited[v]) {
                    list.add(v);
                    queue.offerLast(v);
                    visited[v] = true;
                }
            }
        }

        return list;
    }
}