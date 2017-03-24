/**
 * 08722 Homework1: implements a Java class.
 * @author Xin Wang
 * Andrew ID: xinw3
 */
public class MyArray {
    /**
     * "myArray" is the underlying data structure of this class.
     */
    private String[] myArray;
    /**
     * "capacity" holds the capacity of the array.
     */
    private int capacity;
    /**
     * "size" records the number of elements of the array.
     */
    private int size = 0;
    /**
     * Constant "DEFAULT_CAPACITY" is to assign a capacity if not given.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Constructor with no argument.
     */
    public MyArray() {
        myArray = new String[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }
    /**
     * Constructor with the initialCapacity given.
     * @param initialCapacity given by the declaration of the MyArray object.
     */
    public MyArray(int initialCapacity) {
        if (initialCapacity >= 0) {
            myArray = new String[initialCapacity];
            capacity = initialCapacity;
        } else {
            throw new IllegalArgumentException("Illegal Capacity");
        }
    }
    /**
     * Method to add a String into the array.
     * @param text the String to be added.
     */
    public void add(String text) {
        if (isValid(text)) {
            ensureCapacity(size + 1);
            myArray[size++] = text;
        }
    }
    /**
     * Method to ensure the capacity and double it when necessary.
     * @param minCapacity is the current size + 1(size is before adding).
     */
    public void ensureCapacity(int minCapacity) {
        int oldCapacity = capacity;
        if (minCapacity > oldCapacity) {
            String[] oldArray = myArray;
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            myArray = new String[newCapacity];
            System.arraycopy(oldArray, 0, myArray, 0, size);
            capacity = newCapacity;
        }
    }
    /**
     * Method to search for a particular key.
     * @param key provided to be searched in the array.
     * @return boolean.
     */
    public boolean search(String key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (myArray[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(myArray[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Method to get the number of element of the array.
     * @return int size of the array.
     */
    public int size() {
        return size;
    }
    /**
     * Method to get the current capacity of the array.
     * @return int current capacity.
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Method to display the content of the array.
     */
    public void display() {
        for (String s:myArray) {
            if (isValid(s)) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }
    /**
     * Method to determine whether the String is a valid word.
     * @param s String to be added to the array or displayed.
     * @return boolean.
     */
    public boolean isValid(String s) {
        if ((s != null) && !s.trim().isEmpty()) {
            return s.matches("^[a-zA-Z]+$");
        }
        return false;
    }
    /**
     * Method to remove the duplicate elements in the array.
     */
    public void removeDups() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (myArray[i].equals(myArray[j])) {
                    System.arraycopy(myArray, j + 1, myArray, j, size - j - 1);
                    myArray[size - 1] = null;       //Free GC
                    size--;
                    j--;
                }
            }
        }
    }
}
