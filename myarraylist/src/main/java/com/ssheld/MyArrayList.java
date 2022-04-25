package com.ssheld;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyArrayList<T> implements Iterable<T> {

    public static final int DEFAULT_CAPACITY = 10;

    // Store current size of array
    private int arraySize = 0;
    private T[] arr;

    public MyArrayList() {
        clear();
    }

    /** Add val to end of array **/
    public boolean add(T val) {
        add(getSize(), val);
        return true;
    }

    /** Overloaded add method to add value at a specific index **/
    public void add(int index, T val) {
        // Check if array is full
        if (arr.length == getSize()) {
            // Double the array capacity. +1 used in case size is currently 0.
            changeCapacity(1 + 2 * getSize());
        }

        // Copy items over
        for (int i = getSize(); i > index; i--) {
            arr[i] = arr[i-1];
        }
        // Insert at index
        arr[index] = val;
        arraySize++;
    }

    /** Method to get value at specific index inside array **/
    public T get(int index) {
        if (index < 0 || index >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    /** Set value at specific index in arraylist **/
    public T set(int index, T newVal) {
        if (index < 0 || index >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldVal = arr[index];
        arr[index] = newVal;
        return oldVal;
    }

    /** Clear all values from the array **/
    public void clear() {
        setSize(0);
        changeCapacity(DEFAULT_CAPACITY);
    }

    /** Method to change capacity of array **/
    public void changeCapacity(int newCapacity) {
        if (newCapacity < getSize()) {
            return;
        }

        T[] oldArr = arr;
        arr = (T[]) new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            arr[i] = oldArr[i];
        }
    }

    /** Method to remove a value at a specific index **/
    public T remove(int index) {
        // Get value at index
        T val = arr[index];
        // Shift items over
        for (int i = index; i < getSize() - 1; i++) {
            arr[i] = arr[i+1];
        }
        arraySize--;
        return val;
    }

    /** Getter for size of array **/
    public int getSize() {
        return arraySize;
    }

    /** Setter for size of array **/
    public void setSize(int newSize) {
        arraySize = newSize;
    }

    /** Helper to check if array is empty **/
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /** Trim array to current size **/
    public void trimToSize() {
        changeCapacity(getSize());
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /* Private class to create arraylist iterator */
    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        public boolean hasNext() {
            return current < getSize();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // Return
            return arr[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
