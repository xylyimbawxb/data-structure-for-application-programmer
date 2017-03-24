import java.util.Comparator;
import java.util.Iterator;

public class BST<T extends Comparable<T>> implements Iterable<T>, BSTInterface<T> {
    private Node<T> root;
    private Comparator<T> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    public Comparator<T> comparator() {
        return comparator;
    }

    public T getRoot() {
        throw new RuntimeException("Implement this");
    }

    public int getHeight() {
        throw new RuntimeException("Implement this recursively");
    }

    public int getNumberOfNodes() {
        throw new RuntimeException("Implement this recursively");
    }

    @Override
    public T search(T toSearch) {
        throw new RuntimeException("Implement this recursively");
    }

    @Override
    public void insert(T toInsert) {
        throw new RuntimeException("Implement this recursively");
    }

    @Override
    public Iterator<T> iterator() {
        throw new RuntimeException("Implement this");
    }

    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        Node(T data) {
            this(data, null, null);
        }

        Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}