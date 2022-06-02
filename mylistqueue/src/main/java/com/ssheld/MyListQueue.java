package com.ssheld;

import java.util.NoSuchElementException;

/**
 * Linked list implementation of FIFO Queue.
 */
public class MyListQueue<T> {
    private Node head;
    private Node tail;
    private int stackSize;

    public int getSize() {
        return stackSize;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T val) {
        Node oldTail = tail;
        tail = new Node();
        tail.val = val;
        tail.next = null;

        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        stackSize++;
    }

    public T dequeue() {

        // Remove node from beginning of linked list
        T val = head.val;
        head = head.next;
        stackSize--;

        if (isEmpty()) {
            tail = null;
        }

        return val;
    }

    private class Node {
        T val;
        Node next;
    }

}
