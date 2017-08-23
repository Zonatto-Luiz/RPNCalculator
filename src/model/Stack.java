package model;

/**
 * Doubly LinkListed
 */
public class Stack {
    private Node head;
    private int size = 0;

    /**
     * Add element to top of the list
     *
     * @param element
     */
    public void push(Comparable element) {
        Node node = new Node(element);

        if (this.head == null) {
            this.head = node;

        } else {
            node.setNext(head);
            head = node;
        }
        this.size++;
    }

    /**
     * Get the head node
     *
     * @return head
     */
    public Node peek() {
        return this.head;
    }

    public Boolean empty() {
        return (size > 0) ? false : true;
    }

    public Node pop() {
        Node node = null;
        node = head;
        head = (size > 1) ? head.getNext() : null;
        size--;
        return node;

    }


    /**
     * Search for an element in the list
     *
     * @param
     * @return Object result
     */
    public Comparable search(Comparable e) {
        Node pointer = this.head;
        do {
            if (pointer.getElement().equals(e)) {
                return pointer.getElement();
            }
            pointer = pointer.getNext();
        } while (pointer != null);

        return null;
    }

    public int getSize() {
        return size;
    }
}
