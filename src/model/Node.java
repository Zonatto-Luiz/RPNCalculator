package model;

/**
 * Node class
 *
 * @param <E>
 */
public class Node<E> {
    private Comparable element;
    private Node next;
    private Node prev;

    public Node(Comparable element) {
        this.element = element;
    }

    public Comparable getElement() {
        return element;
    }

    /**
     * Get the next node of the current node
     *
     * @return Node|null
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set the next node of the current nde
     *
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Get the previous node of the current node
     *
     * @return Node|null previous
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * Set previous node
     *
     * @param
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

}
