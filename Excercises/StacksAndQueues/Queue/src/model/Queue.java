package model;

import exception.QueueException;

public class Queue<T extends Comparable<T>> implements Queueable<T> {

    private Node<T> front;
    private Node<T> back;
    private int size;

    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean contains(T element){
        return containsElement(element, this.front);
    }

    private boolean containsElement(T element, Node<T> current){
        if(current == null){
            return false;
        }else if((current.getKey()).compareTo(element) == 0){
            return true;
        }else{
            return containsElement(element, current.getNext());
        }
    }


    @Override
    public T front() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("The Queue is empty");
        }else {
            return front.getKey();
        }
    }

    /*
    @Override
    public T back() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("The Queue is empty");
        }else {
            return back.getKey();
        }
    }
     */

    @Override
    public T dequeue() throws QueueException {
        if(isEmpty()) {
            throw new QueueException("The Queue is empty");
        }else{
            T item = front.getKey();
            front = front.getNext();
            --size;
            return item;
        }
    }

    @Override
    public void enqueue(T item) throws QueueException {
        if(item == null){
            throw new QueueException("The Queue is empty");
        }else {
            Node<T> node = new Node<>(item);
            if (isEmpty()) {
                this.front = node;
            } else {
                this.back.setNext(node);
            }
            this.back = node;
            ++size;
        }
    }

    @Override
    public String toString(){
        return printQueue();
    }

    public String printQueue(){
        Node<T> current = front;
        StringBuilder str = new StringBuilder("[");
        while (current != null) {
            str.append(current.getKey()).append(", ");
            current = current.getNext();
        }
        if(str.toString().equals("[")){
            str.append(" ]");
        }else{
            str.append("\b\b]");
        }
        return str.toString();
    }
}
