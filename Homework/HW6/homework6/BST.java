import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 * 08722 Homework 6. BST class. Andrew ID: xinw3
 * @author Xin Wang
 * Andrew ID: xinw3
 * @param <T>
 */
public class BST<T extends Comparable<T>> implements Iterable<T>, BSTInterface<T> {
    /**
     * root of the tree.
     */
    private Node<T> root;
    /**
     * comparator.
     */
    private Comparator<T> comparator;
    /**
     * no-arg Constructor.
     */
    public BST() {
        this(null);
    }

    /**
     * Constructor with arguments.
     * @param comp comparator.
     */
    public BST(Comparator<T> comp) {
        this.comparator = comp;
        root = null;
    }

    /**
     * Comparator.
     * @return comparator.
     */
    public Comparator<T> comparator() {
        return comparator;
    }

    /**
     * Method to get the root of the BST.
     * @return T the root data.
     */
    public T getRoot() {
        if (root == null) {
            return null;
        }
        return root.data;
    }

    /**
     * Method to get the height of the BST recursively.
     * @return int height of the BST.
     */
    public int getHeight() {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        } else {
            return getHeight(root);
        }
    }

    /**
     * Helper function to get the height of the tree.
     * @param n the root of the tree.
     * @return int height of tree.
     */
    private int getHeight(Node<T> n) {
        // Reach the leaves nodes.
        if (n == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(n.right), getHeight(n.left));
    }

    /**
     * Method to get the number of nodes in the BST recursively.
     * @return int the number of the nodes.
     */
    public int getNumberOfNodes() {
        return getNumberOfNodes(root);
    }

    /**
     * Helper function to get the number of the nodes of the tree recursively.
     * @param n root of the tree.
     * @return int the number of the nodes in BST.
     */
    private int getNumberOfNodes(Node<T> n) {
        if (n == null) {
            return 0;
        }
        return 1 + getNumberOfNodes(n.left) + getNumberOfNodes(n.right);
    }

    /**
     * search an element in BST.
     * If there is no such an element
     * return null.
     * else search in order alphabetically.
     */
    @Override
    public T search(T toSearch) {
        // throw new RuntimeException("Implement this recursively");
        return search(root, toSearch);
    }

    /**
     * Helper function to implement search recursively.
     * @param n root of the tree to search.
     * @param toSearch data to search.
     * @return T null if not exist, data if exist.
     */
    private T search(Node<T> n, T toSearch) {
        if (n == null) {
            return null;
        }
        if (toSearch.compareTo(n.data) == 0) {
            return n.data;
        }
        if (toSearch.compareTo(n.data) < 0) {
            return search(n.left, toSearch);
        } else {
            return search(n.right, toSearch);
        }
    }

    /**
     * insert an element into BST recursively.
     * If there is the same element in the BST
     * update the value(frequency, index).
     * Else insert the element alphabetically.
     */
    @Override
    public void insert(T toInsert) {
        root = insert(root, toInsert);
    }

    /**
     * Helper function to insert a new node.
     * @param n root of the tree to insert the new node.
     * @param toInsert the data of the node to be inserted.
     * @return root of the tree.
     */
    private Node<T> insert(Node<T> n, T toInsert) {
        if (n == null) {
            return new Node<T>(toInsert);
        }
        if (comparator != null) {
            if (comparator.compare(toInsert, n.data) == 0) {
                return n;
            }
            if (comparator.compare(toInsert, n.data) < 0) {
                n.left = insert(n.left, toInsert);
            } else {
                n.right = insert(n.right, toInsert);
            }
        } else {
            if (toInsert.compareTo(n.data) == 0) {
                return n;
            }
            if (toInsert.compareTo(n.data) < 0) {
                n.left = insert(n.left, toInsert);
            } else {
                n.right = insert(n.right, toInsert);
            }
        }
        return n;
    }

    /**
     * In-order iterator to traverse the tree.
     */
    @Override
    public Iterator<T> iterator() {
        return new InorderIterator(root);
    }

    /**
     * Helper class of iterator to traverse the tree. Using stack to track
     * nodes.
     */
    private class InorderIterator implements Iterator<T> {
        /**
         * The stack to store the tree node in order.
         */
        private Stack<Node<T>> treeStack = new Stack<Node<T>>();

        /**
         * Constructor.
         * First Push the left nodes into the stack.
         * @param n root of the tree.
         */
        InorderIterator(Node<T> n) {
            while (n != null) {
                treeStack.push(n);
                n = n.left;
            }
        }

        /**
         * Implement hasNext() method.
         */
        @Override
        public boolean hasNext() {
            return !treeStack.empty();
        }

         /** Implement next() method.
          * Pop left node first and to see if they have right node.
          * If there is right node, first push the right node and
          * see if there is left child of the right node.
          */
        @Override
        public T next() {
            Node<T> node = treeStack.pop();
            T value = node.data;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    treeStack.push(node);
                    node = node.left;
                }
            }
            return value;
        }
    }

    /**
     * private Node class.
     * @param <T>
     */
    private static class Node<T> {
        /**
         * data of the Node.
         */
        private T data;
        /**
         * left child of the Node.
         */
        private Node<T> left;
        /**
         * right child of the Node.
         */
        private Node<T> right;

        /**
         * Constructor with one data argument.
         * @param d the Node data.
         */
        Node(T d) {
            this(d, null, null);
        }

        /**
         * Constructor with arguments.
         * @param d T data of the Node.
         * @param l left child of the Node.
         * @param r right child of the Node.
         */
        Node(T d, Node<T> l, Node<T> r) {
            this.data = d;
            this.left = l;
            this.right = r;
        }

        /**
         * toString method.
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }
}