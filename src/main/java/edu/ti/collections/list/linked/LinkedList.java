package edu.ti.collections.list.linked;

public class LinkedList<T> {
    private class Node {
        T payload;
        Node next = null;

        public Node(T payload) {
            this.payload = payload;
        }

        public T getPayload() {
            return payload;
        }

        public void setPayload(T payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;

    public LinkedList() {
        // nothing
    }

    public LinkedList(T payload) {
        head = new Node(payload);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    //TODO -- implement private helper method end that returns last Node in list
    private Node end() {
        Node endNode = head;
        while (endNode.getNext() != null) {
            endNode = endNode.getNext();
        }
        return endNode;
    }

    //TODO -- implement size to return number of Nodes in list
    public int size() {
        int size = 0;
        for (Node start = head; start != null; start = start.next) {
            size += 1;
        }
        return size;
    }

    //TODO -- implement insert, which inserts Node for object as new head of list
    public void insert(T object) {
        Node newNode = new Node(object);
        newNode.setNext(head);
        head = newNode;
    }

    //TODO -- implement append, that appends Node to end of list
    public void append(T object) {
        Node newNode = new Node(object);
        Node endNode = end();
        if (head == null) {
            head = newNode;
        } else {
            end().setNext(newNode);
        }
    }

    //TODO -- implement get to retrieve the n-th object in the list,
    //        return null if n > (size() - 1)
    public T get(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node requestedNode = head;
            while (n-- > 0) {
                requestedNode = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
        }
        return requestedObject;
    }

    //TODO -- implement remove to remove n-th element of list,
    //        return Object if n < size(), null otherwise
    public T remove(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node beforeRequestedNode = null;
            Node requestedNode = head;
            while (n-- > 0) {
                beforeRequestedNode = requestedNode;
                requestedNode = requestedNode.getNext();
            }
            if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                head  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
        }
        return requestedObject;
    }

    //TODO -- implement remove to remove given object from list,
    //        return Object if object is in the list, null otherwise
    public T remove(T object) {
        T requestedObject = null;
        if (head != null) {
            Node beforeRequestedNode = null;
            Node requestedNode = head;
            boolean foundNode = false;
            do {
                if (requestedNode.getPayload().equals(object)) {
                    foundNode = true;
                } else {
                    beforeRequestedNode = requestedNode;
                    requestedNode = requestedNode.getNext();
                }
            } while (!foundNode && requestedNode.getNext() != null);

            if (beforeRequestedNode != null) {
                beforeRequestedNode.setNext(requestedNode.getNext());
            } else {
                head  = requestedNode.getNext();
            }
            requestedObject = requestedNode.getPayload();
        }
        return requestedObject;
    }
}
