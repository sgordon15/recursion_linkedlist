package edu.ti.collections.list.queue;

import edu.ti.collections.list.linked.LinkedList;

//a Stack is also known as a LIFO queue (Last In First Out)
public class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public T pop() {
        T retval;
        retval = list.get(0);
        return retval;
    }

    public void push(T obj) {
        list.insert(obj);
    }
}
