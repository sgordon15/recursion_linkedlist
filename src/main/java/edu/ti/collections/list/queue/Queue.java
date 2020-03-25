package edu.ti.collections.list.queue;

import edu.ti.collections.list.linked.LinkedList;

public class Queue<T> {
    private LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enqueue(T obj) {
        //TODO: Implement
    }

    public T dequeue() {
        //TODO: Implement
        return null;
    }
}
