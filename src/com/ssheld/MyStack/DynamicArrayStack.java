package com.ssheld.MyStack;

import java.util.Iterator;

/**
 * Author: Stephen Sheldon 3/2/2019
 */

public class DynamicArrayStack<T> implements Iterable<T> {

    private T[] myStack = (T[]) new Object[1];
    // Number of items on stack
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public T top() {
        return myStack[size()-1];
    }

    // Push a new item onto the stack
    public void push(T item) {
        // First we need to check if the array is full
        if (myStack.length == size()) {
            // If array is full then let's resize is by a factor of 2
            resize(size()*2);
        }
        myStack[n++] = item;
    }

    // Pop the top item of type T from the stack
    public T pop() {
        T item = myStack[--n];
        // Avoid loitering due to JVM garbage collection
        // Loitering = holding a reference to an object that is no longer needed
        myStack[n] = null;

        // Check if n is equal to 1/4 current size
        // If so we should resize the array to half it's current size
        // We choose evaluating against length/4 because we want to avoid overflow
        // and situation where we pop and then immediately have to call resize
        // in our next push
        if (n > 0 && n == myStack.length/4) {
            resize(myStack.length/2);
        }
        return item;
    }

    // Resize the stack if user tries to add item and stack is at full capacity
    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = myStack[i];
        }
        myStack = temp;
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = n - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            return myStack[i--];
        }

        // Avoid implementing remove because interleaving iterations
        // with operations that modify the data structure should be avoided.
        // If you did however wish to then you would need to implement a modCount
        public void remove() {}
    }
}
