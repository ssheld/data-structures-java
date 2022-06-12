package com.ssheld;

/**
 * Max Priority Queue implementation
 */
public class MaxPQ<Key extends Comparable<Key>>{

    // Heap ordered complete binary tree
    private final Key[] pq;
    private int n = 0;

    public MaxPQ(int maxSize) {
        pq = (Key[]) new Comparable[maxSize+1];
    }

    /**
     * Insert at end of priority queue and bubble up with swim
     */
    public void insert(Key v) {
        pq[++n] = v;
        swim(n);
    }

    public Key deleteMax() {
        // Retrieve root node
        Key max = pq[1];
        // Bring last node to root
        exchange(1, n--);
        pq[n+1] = null;
        // Sink root
        sink(1);
        return max;
    }

    /**
     * Bubbles up the node k until the key of its parent node is
     * greater than its own key
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    /**
     * Sink a node k until it's key is less than its parent's key
     */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n ==0;
    }

    // Method to compare two Comparable objects
    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // Method to swap two objects in an array
    protected void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
