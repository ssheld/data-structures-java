package ssheld;

/**
 * Linked list implementation of stack
 */
public class MyListStack<T> {

    private Node head;
    private int stackSize;

    public int getSize() {
        return stackSize;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private class Node {
        T val;
        Node next;
    }

    public void push(T val) {
        // Save old head
        Node oldHead = head;
        // Create new head
        head = new Node();
        head.val = val;
        head.next = oldHead;
        stackSize++;
    }

    public T pop() {
        // Remove value from top of stack
        T val = head.val;
        head = head.next;
        stackSize--;
        return val;
    }
}
