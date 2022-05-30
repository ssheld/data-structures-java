package com.ssheld;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayStack<T> implements Iterable<T> {

    // Var to track current stack size
    private int stackSize = 0;

    // Default stack capacity
    private final int DEFAULT_STACK_CAPACITY = 10;

    // Stack
    private T arr[];

    public MyArrayStack() {
        clear();
    }

    // Clear stack and set to defaults
    public void clear() {
        setSize(0);
        changeCapacity(DEFAULT_STACK_CAPACITY);
    }

    private void setSize(int newSize) {
        stackSize = newSize;
    }

    public int getSize() {
        return stackSize;
    }

    public T pop() {
        // Remove from top of stack
        T val = arr[--stackSize];
        // Void loitering
        arr[stackSize] = null;
        // Check if array needs to be resized (if it's 1/4 capacity)
        if (stackSize > 0 && stackSize < arr.length / 4) {
            changeCapacity(arr.length / 2);
        }
        return val;
    }

    public void push(T val) {
        if (arr.length == stackSize) {
            // Double the array capacity. +1 used in case size is currently 0.
            changeCapacity(1 + 2 * stackSize);
        }

        arr[stackSize++] = val;
    }

    /**
     * Change capacity of stack
     **/
    private void changeCapacity(int newCapacity) {

        // Confirm new capacity is greater than current size
        if (newCapacity < stackSize) {
            return;
        }

        T[] oldArr = arr;

        arr = (T[]) new Object[newCapacity];

        // Copy to new array
        for (int i = 0; i < stackSize - 1; i++) {
            arr[i] = oldArr[i];
        }
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int index = stackSize - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return arr[index--];
        }
    }
}
