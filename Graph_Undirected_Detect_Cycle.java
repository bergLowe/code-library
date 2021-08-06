import java.util.ArrayList;

class Solution {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleHelper(adj, visited, i, -1)) return true;
        }
        return false;
    }

    private boolean isCycleHelper (ArrayList<ArrayList<Integer>> adj, boolean[] visited, int vertex, int parent) {
        visited[vertex] = true;

        for (int node: adj.get(vertex)) {
            if (!visited[node] && isCycleHelper(adj, visited, node, vertex)) return true;
            
            /*
            If the node is adjacent to the vertex, then vertex's parent will be the node itself.
            And if the node is not that, then it is connected to another node/vertex that has been
            preivously visited and is a cycle.
            */
            else if (node != parent) return true;
        }
        
        return false;
    }
}