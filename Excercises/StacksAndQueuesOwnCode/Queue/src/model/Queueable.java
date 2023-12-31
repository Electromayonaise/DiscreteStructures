package model;

import exception.QueueException;

public interface Queueable <E extends Comparable<E>> {

    public int size();

    public boolean isEmpty();

    public boolean contains(E element);

    public E front() throws QueueException ;

    public E dequeue()throws QueueException;

    public void enqueue(E item) throws QueueException;

}

