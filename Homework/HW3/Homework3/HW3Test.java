
public class HW3Test {

    public static void main(String[] args) {
//        SortedLinkedList test = new SortedLinkedList();
//        test.add("abcd");
        String[] unsorted = {"bcda", "     ", "cdba", "ddpp  ", "abcd "};
        SortedLinkedList test = new SortedLinkedList(unsorted);
        //test.removeFirst();
        String s = test.removeAt(0);
        System.out.println(s);
        test.display();
    }
}