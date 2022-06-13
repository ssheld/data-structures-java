package com.ssheld;

import java.util.NoSuchElementException;

public class BST <Key extends Comparable<Key>, Value> {

    private class Node {

        private Node root;

        private Key key;
        private Value val;
        private Node left, right;  // Left and right subtrees
        private int n;             // Number of nodes in subtree rooted here

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }

        /**
         * Public facing method to get size of BST.
         */
        public int size() {
            return size(root);
        }

        /**
         * Private overloaded method to return size of tree
         * starting at root node x
         */
        private int size(Node x) {
            if (x == null) {
                return 0;
            } else {
                return x.n;
            }
        }

        /**
         * Public facing method to return the value of a specific key.
         */
        public Value get(Key key) {
            return get(root, key);
        }

        /**
         * Private overloaded method to return value of specific key.
         */
        private Value get(Node x, Key key) {
            if (x == null) {
                return null;
            }

            // Compare the keys
            int cmp = key.compareTo(x.key);

            // Traverse subtrees looking for key
            if (cmp < 0) {
                // Key is smaller than current node.
                // Go down left subtree.
                get(x.left, key);
            } else if (cmp > 0) {
                // Key is larger than current node.
                // Go down right subtree
                get(x.right, key);
            }

            // Key has been found
            return x.val;
        }

        /**
         * Public facing put method
         */
        public void put(Key key, Value val) {
            root = put(root, key, val);
        }

        /**
         * Private overloaded method to put key value pair into tree
         */
        private Node put(Node x, Key key, Value val) {
            // Base case: our node is null so insert here
            if (x == null) {
                return new Node(key, val, 1);
            }

            int cmp = key.compareTo(x.key);
            // Compare key to current node
            if (cmp < 0) {
                // Key is smaller than current node so move left.
                x.left = put(x.left, key, val);
            } else if (cmp > 0) {
                // Key is larger than current node so move right.
                x = put(x.right, key, val);
            } else {
                // Key is equal to current node so update the value.
                x.val = val;
            }

            // Update the size. We add a +1 to each node up the tree
            // to account for our new node we've inserted.
            x.n = size(x.left) + size(x.right) + 1;

            return x;
        }

        /**
         * Retrieves the minimum key in the BST
         */
        public Key min() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Node x = min(root);
            return x.key;
        }

        /**
         * Private overloaded min method to retrieve node with
         * minimum key in BST.
         */
        private Node min(Node x) {
            if (x.left == null) {
                return x;
            }
            return min(x.left);
        }

        /**
         * Retrieves maximum key in BST
         */
        public Key max() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Node x = max(root);
            return x.key;
        }

        /**
         * Private overloaded max method to retrieve node with
         * maximum key in BST.
         */
        private Node max(Node x) {
            if (x.right == null) {
                return x;
            }
            return max(x.right);
        }

        /**
         * Retrieves the largest key in the BST less than or
         * equal to the argument key.
         */
        public Key floor(Key key) {
            Node x = floor(root, key);
            if (x == null) {
                throw new NoSuchElementException();
            }
            return x.key;
        }

        /**
         * Private overloaded floor method.
         */
        private Node floor(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);

            // Case: Key is less than key at root
            if (cmp == 0) {
                return x;
            }
            // Case: Key is the same as key at root
            else if (cmp < 0) {
                floor(x.left, key);
            }

            // Case: Key is greater than key at root
            Node t = floor(x.right, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }

        /**
         * Returns the key of rank k (The key such that precisely k
         * other keys in the BST are smaller).
         */
        public Key select(int k) {
            if (k < 0 || k >= size()) {
                throw new IllegalArgumentException();
            }
            Node x = select(root, k);
            return x.key;
        }

        /**
         * Private overloaded select method.
         */
        private Node select(Node x, int k) {
            if (x == null) {
                return null;
            }

            int t = size(x.left);

            if (t > k) {
                return select(x.left, k);
            } else if (t < k) {
                return select(x.right, k-t-1);
            } else {
                return x;
            }
        }

        /**
         * Helper method to check if BST is empty.
         */
        public boolean isEmpty() {
            return n == 0;
        }
    }
}
