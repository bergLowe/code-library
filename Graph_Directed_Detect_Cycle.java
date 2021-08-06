import java.util.ArrayList;

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        /*
        trackBackEdge keeps track of all visited nodes to reach that particular nodes
        and if that node connects back to any of the previously visited nodes, then it 
        is a cycle. So we mark true for the visiting node and if cycle is not found we 
        toggle it to false.
        */
        boolean[] trackBackEdge = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicHelper(adj, visited, trackBackEdge, i)) return true;
        }

        return false;
    }

    private boolean isCyclicHelper (ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] trackBackEdge, int vertex) {
        visited[vertex] = true;
        trackBackEdge[vertex] = true;

        for (int node: adj.get(vertex)) {
            if (!visited[node] && isCyclicHelper(adj, visited, trackBackEdge, node)) return true;
            else if (trackBackEdge[node]) return true;
        }

        trackBackEdge[vertex] = false;
        return false;
    }
}