/**
 * 08722 Data Structures for Application Programmers.
 * Lecture 6 Stack
 * A very simple Stack Class using an array
 *
 * @author Terry Lee
 * @param <AnyType> type of elements
 */
public class ArrayStack<AnyType> implements StackInterface<AnyType> {
    /**
     * Constant for default capacity of the underlying array.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * An array of elements.
     */
    private Object[] elements;
    /**
     * Location of top element.
     */
    private int top;

    /**
     * construct a new stack with initial capacity
     * @param initialCapacity an initial length of the stack
     */
    public ArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            elements = new Object[initialCapacity];
        }
        top = -1;
    }

    /**
     * No-arg constructor.
     */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Pushes a new item onto the top of the stack in O(1).
     * @param item a new item to add
     * @throws StackException if stack is full
     */
    @Override
    public void push(AnyType item) {
        if (top == (elements.length - 1)) {
            throw new StackException("Stack is full");
        }
        elements[++top] = item;
    }

    /**
     * Gets and removes the item on the top in O(1).
     * @return Top item
     * @throws StackException indicates that stack is empty
     */
    @Override
    public AnyType pop() {
        if (isEmpty()) {
            throw new StackException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        AnyType item = (AnyType) elements[top];
        elements[top] = null;
        top--;
        return item;
    }

    /**
     * Gets (peeks) the top element in O(1). Does not delete it!
     * @return Top element
     * @throws StackException indicates that stack is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public AnyType peek() {
        if (isEmpty()) {
            throw new StackException("Stack is empty");
        }
        return (AnyType) elements[top];
    }

    /**
     * Checks if the stack is empty or not in O(1).
     * @return true if it is empty, false if it is not empty
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * A few test cases.
     * @param args arguments
     */
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(6);
        stack.push(1);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        System.out.println(stack.peek()); // 1
        stack.push(2);
        stack.push(10);
        stack.push(5);
        stack.push(4);
        stack.push(8);
        System.out.println(stack.peek()); // 8
        System.out.println(stack.pop()); // 8
        System.out.println(stack.peek()); // 4
        stack.push(9);
        stack.push(11); // exception : stack is full
    }

}

/**
 * StackException class to throw in ArrayStack class.
 */
@SuppressWarnings("serial")
class StackException extends RuntimeException {
    /**
     * Constructor with a specific message.
     * @param message message to print
     */
    StackException(String message) {
        super(message);
    }

    /**
     * Constructor without any message.
     */
    StackException() {
        super();
    }
}
