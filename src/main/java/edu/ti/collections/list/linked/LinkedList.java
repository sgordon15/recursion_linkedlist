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

    private Node end() {
        Node endNode = head;
        while (endNode.getNext() != null) {
            endNode = endNode.getNext();
        }
        return endNode;
    }

    public int size() {
        int size = 0;
        for (Node start = head; start != null; start = start.next) {
            size += 1;
        }
        return size;
    }

    public void insert(T object) {
        Node newNode = new Node(object);
        newNode.setNext(head);
        head = newNode;
    }

    public void append(T object) {
        Node newNode = new Node(object);
        Node endNode = end();
        if (head == null) {
            head = newNode;
        } else {
            end().setNext(newNode);
        }
    }

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
