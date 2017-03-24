public class Quiz2Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> theQueue = new ArrayQueue<Integer>(8);
        for (int i = 7; i >= 1; i++) {
            theQueue.enqueue(i);
        }
    }
}