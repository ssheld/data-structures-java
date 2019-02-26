package com.ssheld.MyLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Author: Stephen Sheldon 2/24/2019
 */

public class MyLinkedList<T> implements Iterable<T>{

    /* Current size of list */
    private int theSize;
    /* Track stored modCount to check against iterator modCount */
    private int modCount = 0;
    /* Reference to first node in list */
    private Node<T> beginMarker;
    /* Reference to last node in list */
    private Node<T> endMarker;

    public MyLinkedList() {
        /* New list, init list markers to null */
        clear();
    }

    /* Node class */
    /* Store reference to next node and previous node */
    /* along with node data */
    private static class Node<T> {

        public Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        T data;
        Node<T> next;
        Node<T> prev;
    }

    /* Get the size of the LinkedList */
    public int size() {
        return theSize;
    }

    /* Check if LinkedList is currently empty */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* Clear collection by changing size of it to zero */
    public void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, null, beginMarker);
        theSize = 0;
        modCount++;
    }

    /* Trivial case when adding node to end of list */
    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    /* Adding node to specific index in list */
    public void add(int index, T x) {
        addBefore(getNode(index), x);
    }

    /* Get value of node at a specific index */
    public T get(int index) {
        return getNode(index).data;
    }

    /* Set new value of a node at a specific index and */
    /* return the old value of that node */
    public T set(int index, T newVal) {
        Node<T> p = getNode(index);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }


    /* Add new node containing data x before node p */
    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<T>(x, p, p.prev);
        p.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    /* Basic remove at index, return the removed data */
    public T remove(int index) {
        return remove(getNode(index));
    }

    /* Remove node P data */
    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        /* Decrement size of LinkedList */
        theSize--;
        /* Update the modCount for iterator check */
        modCount++;
        return p.data;
    }

    /* Get a node at a specific index */
    private Node<T> getNode(int index) {
        Node<T> p;

        /* Edge case if we're out of bounds on the index */
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        /* Check if index is in first half of LinkedList */
        if(index < size()/2) {
            p = beginMarker.next;

            for(int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        /* Else index is in second half of LinkedList */
        else {
            p = endMarker;

            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        /* Start at the first node */
        private Node<T> current = beginMarker.next;
        private int expectedCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext() {
            return current != endMarker;
        }

        public T next() {
            /* Check modcount */
            if(expectedCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if(expectedCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if(!okToRemove) {
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedCount++;
            okToRemove = false;
        }
    }
}
