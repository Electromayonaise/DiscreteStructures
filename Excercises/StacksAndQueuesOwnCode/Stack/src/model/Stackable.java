package model;

import exception.StackException;

public interface Stackable <T> {

    public boolean isEmpty();
    public void push(T item) throws StackException;
    public T top() throws StackException;
    public T pop() throws StackException;

}

