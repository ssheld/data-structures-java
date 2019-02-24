package com.ssheld.MyArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author: Stephen Sheldon 2/23/2019
 */

public class MyArrayList<T> implements Iterable<T> {

    /* Set default array size */
    private static final int DEFAULT_CAPACITY = 10;

    private int arraySize = 0;
    private T[] arr;

    // Clear the array in the constructor
    public MyArrayList() {
        clear();
    }

    /* Get value at index */
    public T get(int index) {
        if(index < 0 || index >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[index];
    }

    /* Set new value and return old value */
    public T set(int index, T newVal) {
        if(index < 0 || index >= getSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T oldValue = arr[index];
        arr[index] = newVal;
        return oldValue;
    }

    /* Item value to end of array */
    public boolean add(T value) {
        add(getSize(), value);
        return true;
    }

    /* Overload add method to add value at specific index */
    public void add(int index, T value) {
        if(arr.length == getSize()) {
            /* We need to double the capacity */
            changeCapacity(getSize() * 2 + 1);
        }
        /* Copy items over */
        for(int i = getSize(); i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = value;

        arraySize++;
    }

    /* Clear all values from the array */
    public void clear() {
        arraySize = 0;
        changeCapacity(DEFAULT_CAPACITY);
    }

    /* Getter method for array size */
    public int getSize() {
        return arraySize;
    }

    /* Check if array is empty */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /* Trim the array to current size */
    public void trimToSize() {
        changeCapacity(getSize());
    }

    /* Change capacity of array */
    public void changeCapacity(int newCapacity) {
        if(newCapacity < getSize()) {
            return;
        }

        T[] oldArr = arr;
        arr = (T[]) new Object[newCapacity];
        for(int i = 0; i < getSize(); i++) arr[i] = oldArr[i];
    }

    /* Method to remove an item from the array */
    public T remove(int index) {
        T removedItem = arr[index];
        for(int i = index; i < getSize()-1; i++) {
            arr[i] = arr[i+1];
        }
        arraySize--;
        return removedItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /* Private class to create an arraylist iterator */
    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        public boolean hasNext() {
            return current < getSize();
        }

        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return arr[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}