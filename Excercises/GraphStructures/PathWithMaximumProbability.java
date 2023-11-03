
package Excercises.GraphStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

class PathWithMaximumProbability {

    public static void main(String[] args) {
        PathWithMaximumProbability pathWithMaximumProbability = new PathWithMaximumProbability();
        int n = 4;
        int[][] edges = {{0,1},{1,2},{0,2},{0,3}};
        double[] succProb = {0.5,0.5,0.2, 0.1};
        int start = 0;
        int end = 2;
        System.out.println(pathWithMaximumProbability.maxProbability(n, edges, succProb, start, end));
        System.out.println(pathWithMaximumProbability.maxProbabilityV2(n, edges, succProb, start, end));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

         Map <Integer, List <double[]>> graph = new HashMap<>();
         for (int i = 0; i < edges.length; i++) {

            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        double[] prob = new double[n]; 
        prob[start] = 1.0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int next = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (next == -1 || prob[j] > prob[next])) {
                    next = j;
                }
            }
            visited[next] = true;
            for (double[] edge : graph.getOrDefault(next, new ArrayList<>())) {
                prob[(int)edge[0]] = Math.max(prob[(int)edge[0]], prob[next] * edge[1]);
            }

            if (next == end) {
                return prob[next];
            }
            
        }
        return 0.0;        
        
    }

    public double maxProbabilityV2(int n, int[][] edges, double[] succProb, int start, int end) {

        Queue <Integer> queue = new LinkedList<>();
        queue.add(start);
        double[] prob = new double[n];
        prob[start] = 1.0;
        int next;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][0] == node) {
                    next = edges[i][1];
                    if (prob[next] < prob[node] * succProb[i]) {
                        prob[next] = prob[node] * succProb[i];
                        queue.add(next);
                    }
                } else if (edges[i][1] == node) {
                    next = edges[i][0];
                    if (prob[next] < prob[node] * succProb[i]) {
                        prob[next] = prob[node] * succProb[i];
                        queue.add(next);
                    }
                }
            }
        }
        return prob[end];
    
    }

    public double maxProbabilityV3(int n, int[][] edges, double[] succProb, int start, int end) {

        Map <Integer, List <double[]>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {

            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        double[] prob = new double[n]; 
        prob[start] = 1.0;
        boolean[] visited = new boolean[n];
        Queue <Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for (double[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited[(int)edge[0]] && prob[(int)edge[0]] < prob[node] * edge[1]) {
                    prob[(int)edge[0]] = prob[node] * edge[1];
                    queue.add((int)edge[0]);
                }
            }
        }
        return prob[end];
    
    }
     
}