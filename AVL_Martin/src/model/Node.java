package model;

public class Node {

    private Node left;

    private Node right;
    private int key;

    private int depth;

    public Node (int key) {

        this.key = key;
        this.depth = 1;
    }

    public Node getLeft () {
        return left;
    }

    public void setLeft (Node left) {
        this.left = left;
    }

    public Node getRight () {
        return right;
    }

    public void setRight (Node right) {
        this.right = right;
    }

    public int getKey () {
        return key;
    }

    public void setKey (int key) {
        this.key = key;
    }

    public int getDepth () {
        return depth;
    }

    public void setDepth (int depth) {
        this.depth = depth;
    }

    
}