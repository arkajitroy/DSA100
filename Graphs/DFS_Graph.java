package Graphs;

import java.util.LinkedList;

class Graph {
    private int vertices;
    private LinkedList<Integer> []adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adjList[v].add(w);
    }

    public void DFS(int startVertex){
        boolean []visited = new boolean[vertices];
        DFSUtils(startVertex, visited);
    }

    private void DFSUtils(int vertex, boolean []visited ){
        visited[vertex] = true;
        System.out.println(vertex+ " ");

        for(Integer neighbour : adjList[vertex]){
            if(!visited[neighbour]) DFSUtils(neighbour, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("DFS (start from 0) : ");
        graph.DFS(0);
    }
}
