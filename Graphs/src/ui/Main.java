package ui;

import java.util.Scanner;
import model.Graph;
import model.GraphRepresentation;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Graph Representation Program");
            System.out.println("1. Create a Graph");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                Graph graph = createGraph(scanner);
                printGraphRepresentation(graph, scanner);
            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static Graph createGraph(Scanner scanner) {
        System.out.print("Enter the number of vertices (Nodes): ");
        int V = scanner.nextInt();

        System.out.print("Is the graph directed? (yes/no): ");
        String isDirectedInput = scanner.next();
        boolean isDirected = isDirectedInput.equals("yes");

        Graph graph = new Graph(V, isDirected);

        System.out.print("Is the graph weighted? (yes/no): ");
        String isWeighted = scanner.next();

        System.out.print("Enter the number of edges (connections): ");
        int E = scanner.nextInt();

        for (int i = 0; i < E; i++) {
            System.out.print("Enter an edge (source destination" + (isWeighted.equals("yes") ? " weight" : "") + "): ");
            int source = scanner.nextInt() - 1; // Subtract 1 to make it 0-indexed
            int destination = scanner.nextInt() - 1; // Subtract 1 to make it 0-indexed
            int weight = (isWeighted.equals("yes")) ? scanner.nextInt() : 1;
            graph.addEdge(source, destination, weight);
        }

        return graph;
    }

    public static void printGraphRepresentation(Graph graph, Scanner scanner) {
        while (true) {
            System.out.print("Choose representation (matrix/list/exit): ");
            String representationType = scanner.next();

            if (representationType.equals("matrix")) {
                String adjacencyMatrix = GraphRepresentation.getAdjacencyMatrix(graph);
                System.out.println(adjacencyMatrix);
            } else if (representationType.equals("list")) {
                String adjacencyList = GraphRepresentation.getAdjacencyList(graph);
                System.out.println(adjacencyList);
            } else if (representationType.equals("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid representation choice. Please choose 'matrix', 'list', or 'exit'.");
            }
        }
    }

}
