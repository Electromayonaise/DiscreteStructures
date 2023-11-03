package Excercises.GraphStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;



public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        Node clone = cloneGraph.cloneGraph(node1);
        System.out.println(clone.val);
        System.out.println(clone.neighbors.get(0).val);
        Node clone2 = cloneGraph.cloneGraphWithDFS(node1);
        System.out.println(clone2.val);
        System.out.println(clone2.neighbors.get(0).val);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map <Node, Node> map = new HashMap<>();
        Queue <Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }


    public Node cloneGraphWithDFS(Node node) {
        if (node == null) {
            return null;
        }
        Map <Node, Node> map = new HashMap<>();
        return cloneGraphWithDFSHelper(node, map);
    }

    public Node cloneGraphWithDFSHelper(Node node, Map <Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphWithDFSHelper(neighbor, map));
        }
        return clone;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}