package edu.ti.collections.list.linked;
class RecursiveLinkedList<T> {
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

    private Node headNode = null;
    Node endNode = null;  //took away "private"

    public RecursiveLinkedList() {
        // nothing
    }

    public RecursiveLinkedList(T payload) {
        headNode = new Node(payload);
        endNode = headNode;
    }

    public boolean isEmpty() {
        return (headNode == null);
    }

    //entry condition that head is not null
    //removed "private"
//    Node end() {
//        Node endNode = headNode;
//        while (endNode.getNext() != null) {
//            endNode = endNode.getNext();
//        }
//        return endNode;
//    }

    private Node end() {
        return lastNode(headNode);
    }

    private Node lastNode(Node node) {
        Node lastNode = null;
        if (node == null) {
            lastNode = null;
        }
        else if (node.next == null) {
            lastNode = node;
        }
        else {
            lastNode = lastNode(node.next);
        }
        return lastNode;
    }


//    public int size() {
//        int size = 0;
//        for (Node start = headNode; start != null; start = start.next) {
//            size += 1;
//        }
//        return size;
//    }

    public int size() {
        return sizeHelper(headNode);
    }

    int sizeHelper(Node node) {
        int size = (node==null) ? 0:1 + sizeHelper(node.next);
        return size;
    }

    public void insert(T object) {
        Node newNode = new Node(object);
        newNode.setNext(headNode);
        if (headNode == null) {
            endNode = newNode;
        }
        headNode = newNode;
    }

    public void append(T object) {
        Node newNode = new Node(object);
        if (headNode == null) {
            headNode = newNode;
            endNode = newNode;
        } else {
            endNode.setNext(newNode);
            endNode = newNode;
        }
    }

//    public T get(int n) {
//        T requestedObject = null;
//        if (n < size()) {
//            Node requestedNode = headNode;
//            while (n-- > 0) {
//                requestedNode = requestedNode.getNext();
//            }
//            requestedObject = requestedNode.getPayload();
//        }
//        return requestedObject;
//    }

    public T get(int n) {
        T requestedObject = null;
        if (n < size()) {
            requestedObject = getRequestedObject(n, headNode).getPayload();
        }
        return requestedObject;
    }

    private Node getRequestedObject(int n, Node node) {
        Node requestedNode = (n==0)? node:getRequestedObject(n-1,node.next);
        return requestedNode;
    }

    public T remove(int n) {
        T requestedObject = null;
        if (n < size()) {
            Node beforeRequestedNode = null;
            Node requestedNode = headNode;
            while (n-- > 0) { //goes to requested node
                beforeRequestedNode = requestedNode;
                requestedNode = requestedNode.getNext();
            }
            if (beforeRequestedNode != null) { //if want to remove node from somewhere in middle of the list
                beforeRequestedNode.setNext(requestedNode.getNext()); //remove requested node
            } else {  //if it's the first node in the list that you want to remove
                headNode = requestedNode.getNext(); //remove first node/change headNode to the next node
            }
            requestedObject = requestedNode.getPayload();
            if (requestedNode.getNext() == null) {
                endNode = beforeRequestedNode;                   //recalculate the endNode
            }
        }
        return requestedObject;
    }

    public T remove(T object) {
        T requestedObject = null;
        if (headNode != null) {
            Node beforeRequestedNode = null;
            Node requestedNode = headNode;
            boolean foundNode = false;
            do {
                if (requestedNode.getPayload().equals(object)) {
                    foundNode = true;
                } else {
                    beforeRequestedNode = requestedNode;
                    requestedNode = requestedNode.getNext();
                }
            } while (!foundNode && requestedNode.getNext() != null);
            if (beforeRequestedNode != null) { //if not deleting first node
                beforeRequestedNode.setNext(requestedNode.getNext()); //delete requestedNode
            } else { //if you want to delete the first node from the list
                headNode = requestedNode.getNext(); //make the second node be the first node
            }
            requestedObject = requestedNode.getPayload();
            if (requestedNode.getNext() == null) {
                endNode = beforeRequestedNode;
            }
        }
        return requestedObject;
    }
}



