import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFSGraph {
    private int vertices;
    private LinkedList<Integer>[] adj;

    public DFSGraph(int v) {
        this.vertices = v;
        this.adj = new LinkedList[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        // Undirected graph.
        adj[v].add(w);
        adj[w].add(v);
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[this.vertices];
        DFSTraverse(startVertex, visited);
    }

    private void DFSTraverse(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println((vertex + 1) + " ");
        Iterator<Integer> iter = adj[vertex].listIterator();
        while(iter.hasNext()) {
            int v = iter.next();
            if (!visited[v]) {
                DFSTraverse(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edge = sc.nextInt();
        DFSGraph graph = new DFSGraph(vertices);
        int a, b;

        for (int i = 0; i < edge; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            graph.addEdge(a - 1, b - 1);
        }
        int startVertex = sc.nextInt();
        graph.DFS(startVertex - 1);

        sc.close();
    }
}
