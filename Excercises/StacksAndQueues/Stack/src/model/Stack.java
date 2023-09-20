package model;

import exception.StackException;

public class Stack<T> implements Stackable<T>{

    private Node<T> top;

    public Stack(){}

    public Stack(Node<T> top) {
        this.top = top;
    }

    // This is a copy constructor that creates a new stack with the same elements as the other stack 
    public Stack(Stack<T> otherStack) throws StackException {
        this.top = null;
        while (!otherStack.isEmpty()) {
            T item = otherStack.pop();
            this.push(item);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T item) throws StackException {
        if(item == null){
            throw new StackException("Cannot push a null item onto the stack");
        }
        Node<T> node = new Node<>(item);
        if (!isEmpty()) {
            node.setNext(this.top);
        }
        this.top = node;
    }

    @Override
    public T top() throws StackException {
        if(isEmpty()){
            throw new StackException("The stack is empty");
        }else{
            return top.getKey();
        }
    }

    @Override
    public T pop() throws StackException {
        if(isEmpty()) {
            throw new StackException("The stack is empty");
        }else{
            T item = top.getKey();
            top = top.getNext();
            return item;
        }
    }

    @Override
    public String toString(){
        return printStack();
    }

    public String printStack(){
        Node<T> current = top;
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
