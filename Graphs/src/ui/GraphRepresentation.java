package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        V = vertices;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        adjacencyList.get(source).add(edge);
    }

    public List<List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}

class Edge {
    int destination;
    int weight;

    public Edge(int dest, int weight) {
        this.destination = dest;
        this.weight = weight;
    }
}

public class GraphRepresentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        System.out.print("Is the graph weighted? (yes/no): ");
        String isWeighted = scanner.next();

        System.out.println("Is the graph directed? (yes/no): ");
        String isDirected = scanner.next();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        for (int i = 0; i < E; i++) {
            System.out.print("Enter an edge (source destination" + (isWeighted.equals("yes") ? " weight" : "") + "): ");
            int source = scanner.nextInt() - 1; // Subtract 1 to make it 0-indexed
            int destination = scanner.nextInt() - 1; // Subtract 1 to make it 0-indexed
            if (isWeighted.equals("yes")) {
                int weight = scanner.nextInt();
                graph.addEdge(source, destination, weight);
            } else {
                graph.addEdge(source, destination, 1); // Unweighted graph
            }
        }


        System.out.print("Choose representation (matrix/list): ");
        String representationType = scanner.next();

        if (representationType.equals("matrix")) {
            printAdjacencyMatrix(graph);
        } else if (representationType.equals("list")) {
            printAdjacencyList(graph);
        } else {
            System.out.println("Invalid representation choice. Please choose 'matrix' or 'list'.");
        }
    }

    public static void printAdjacencyMatrix(Graph graph) {
        List<List<Edge>> adjacencyList = graph.getAdjacencyList();

        int V = adjacencyList.size();
        int[][] adjacencyMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (Edge edge : adjacencyList.get(i)) {
                adjacencyMatrix[i][edge.destination] = edge.weight;
            }
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printAdjacencyList(Graph graph) {
        List<List<Edge> > adjacencyList = graph.getAdjacencyList();

        System.out.println("Adjacency List:");
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + " -> ");
            for (Edge edge : adjacencyList.get(i)) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}
