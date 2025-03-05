public class MyList<E> {
    private final Integer ELEMENT_A = 1;
    private final Integer ELEMENT_B = 2;
    private final Integer ELEMENT_C = 3;
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        private Node next;
        private Node prev;
        private E data;

        public Node(E data) {
            this.data = data;
            this.next = this.prev = null;
        }

        public E getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    /**
     * Add a new node at the front of the list
     * @param key the data to be added
     */
    public void addAtFront(E key) {
        Node newNode = new Node(key);
        if (size != 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }

        head = newNode;
        size++;
    }

    /**
     * Reverse the double linked list
     */
    public void reverse() {
        Node current = head;
        Node temp = null;
    
        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev(); // Move to the next node in the original order
        }
    
        // Swap head and tail
        if (temp != null) {
            head = temp.prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (Node element = head; element != null; element = element.next) {
            str.append(element.getData().toString());
            str.append(", ");
        }
        if (size > 0) {
            str.delete(str.length() - 2, str.length()); // remove trailing ", "
        }
        str.append("]");
        return str.toString();
    }


    public static void main(String args[]) {
        // Quick smoke test here
        // E.g. Insert 1, 2,. . ., n into the list
        // Print the original list
        // Call your reverse method to reverse the list
        // Print the list after reversing to verify
        MyList<Integer> list = new MyList<>();
        list.addAtFront(list.ELEMENT_A);
        list.addAtFront(list.ELEMENT_B);
        list.addAtFront(list.ELEMENT_C);
        System.out.println("Original list: " + list);
        list.reverse();
        System.out.println("Reversed list: " + list);
    }
}
