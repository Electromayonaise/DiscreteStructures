package model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final boolean isDirected;
    private final List<List<Edge>> adjacencyList;

    public Graph(int vertices, boolean isDirected) {
        this.isDirected = isDirected;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        adjacencyList.get(source).add(edge);
        if (!isDirected) {
            // If undirected, add an edge in the opposite direction as well
            edge = new Edge(source, weight);
            adjacencyList.get(destination).add(edge);
        }
    }

    public List<List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public boolean isDirected() {
        return isDirected;
    }
}

