package model;

import java.util.List;

public class GraphRepresentation {
    public static String getAdjacencyMatrix(Graph graph) {
        List<List<Edge>> adjacencyList = graph.getAdjacencyList();
        int V = adjacencyList.size();
        int[][] adjacencyMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (Edge edge : adjacencyList.get(i)) {
                adjacencyMatrix[i][edge.destination] = edge.weight;
                if (!graph.isDirected()) {
                    // If undirected, set the opposite direction as well
                    adjacencyMatrix[edge.destination][i] = edge.weight;
                }
            }
        }

        StringBuilder matrixString = new StringBuilder("Adjacency Matrix:\n");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrixString.append(adjacencyMatrix[i][j]).append(" ");
            }
            matrixString.append("\n");
        }

        return matrixString.toString();
    }

    public static String getAdjacencyList(Graph graph) {
        List<List<Edge>> adjacencyList = graph.getAdjacencyList();

        StringBuilder listString = new StringBuilder("Adjacency List:\n");
        for (int i = 0; i < adjacencyList.size(); i++) {
            listString.append(i + 1).append(" -> ");
            for (Edge edge : adjacencyList.get(i)) {
                listString.append("(").append(edge.destination + 1);
                if (edge.weight != 1) {
                    listString.append(", ").append(edge.weight);
                }
                listString.append(") ");
            }
            listString.append("\n");
        }

        return listString.toString();
    }
}
