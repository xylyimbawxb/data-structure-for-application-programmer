import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 08722 Data Structures for Application Programmers.
 * Homework Assignment 2
 * Solve Josephus problem with different data structures
 * and different algorithms and compare running times
 *
 * Andrew ID: xinw3
 * @author Xin Wang
 */
public class Josephus {

    /**
     * Uses ArrayDeque class as Queue/Deque to find the survivor's position.
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithAD(int size, int rotation) {
        if (size < 0 || rotation <= 0) {
            throw new RuntimeException("RuntimeException");
        }
        ArrayDeque<Integer> theAD = new ArrayDeque<Integer>(size);
        for (int i = 1; i <= size; i++) {
            theAD.addLast(i);
        }
        int num = size;
        while (num > 1) {
            for (int i = 0; i < rotation; i++) {
                theAD.addLast(theAD.removeFirst());
            }
            theAD.removeLast();
            num--;
        }
        return theAD.peek();
    }

    /**
     * Uses LinkedList class as Queue/Deque to find the survivor's position.
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLL(int size, int rotation) {
        if (size < 0 || rotation <= 0) {
            throw new RuntimeException("RuntimeException");
        }
       LinkedList<Integer> theLL = new LinkedList<Integer>();
        for (int i = 1; i <= size; i++) {
            theLL.addLast(i);
        }
        int num = size;
        while (num > 1) {
            for (int i = 0; i < rotation; i++) {
                theLL.addLast(theLL.removeFirst());
            }
            theLL.removeLast();
            num--;
        }
        return theLL.peek();
    }

    /**
     * Uses LinkedList class to find the survivor's position.
     * However, do NOT use the LinkedList as Queue/Deque
     * Instead, use the LinkedList as "List"
     * That means, it uses index value to find and remove a person to be executed in the circle
     *
     * Note: Think carefully about this method!!
     * When in doubt, please visit one of the office hours!!
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLLAt(int size, int rotation) {
        if (size < 0 || rotation <= 0) {
            throw new RuntimeException("RuntimeException");
        }
        LinkedList<Integer> theLLAt = new LinkedList<Integer>();
        int num = size;
        int index = (rotation - 1) % num;
        for (int i = 1; i <= size; i++) {
            theLLAt.addLast(i);
        }
        while (num > 1) {
            theLLAt.remove(index);
            num = num - 1;
            index = (index + rotation - 1) % num;
        }
        return theLLAt.get(index);
    }
}
