package model;

public class Node<T extends Comparable<T>> {

    private T key;
    private Node<T> next;

    public Node(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return ""+key;
    }
}
