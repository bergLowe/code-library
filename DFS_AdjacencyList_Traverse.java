// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

import java.util.ArrayList;

class Solution {
    ArrayList<Integer> list;
    boolean[] visited;
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        this.list = new ArrayList<>(V);
        this.visited = new boolean[V];

        this.list.add(0);
        DSATraverse(adj, 0);

        return list;
    }

    private void DSATraverse (ArrayList<ArrayList<Integer>> adj, int vertex) {
        if (adj.get(vertex).size() == 0) return ;
        this.visited[vertex] = true;
        for (int v: adj.get(vertex)) {
            if (!visited[v]) {
                this.list.add(v);
                DSATraverse(adj, v);
            }
        }
    }
}