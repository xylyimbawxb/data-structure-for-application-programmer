import java.util.Arrays;

public class Quiz1Test {
    public static void main(String[] args) {
    String course = "08722";
    Object[] a = {Integer.valueOf(1), course, new int[2]};
    Object[] b = a.clone();
    //b[1] = new String("08722");
    System.out.println(a == b);
    //((int[])(a[2]))[0] = 1;
//    System.out.println("b = a.clone(): " + a.equals(b));
   // System.out.println(((int[])a[2])[0]);
//    System.out.println("a[1] == b[1]: " + (a[1] == b[1]));
//    System.out.println("a[1].equals(b[1]): " + a[1].equals(b[1]));
//    System.out.println("a[2] == b[2]: " + (a[2] == b[2]));
//    System.out.println("a[2].equlas(b[2]): " + a[2].equals(b[2]));
//    
//    System.out.println(Arrays.toString((int[])a[2]));
//    System.out.println(Arrays.toString((int[])b[2]));
//    System.out.println(Arrays.toString(a));
//    System.out.println(Arrays.toString(e));
//    System.out.println(a.toString());
//    System.out.println(Arrays.equals(a, b));
    
//    b[1] = new String("08722");
//    b[2] = new int [1];
    
    //((int[])(b[2]))[0] = 1;
    
//    System.out.println(a == b);
//    System.out.println(a[1].equals(b[1]));
//    System.out.println(a[1] == b[1]);
//    System.out.println(Arrays.equals(a, b));
    //System.out.println(a[2].toString());
    }
    //binary search return -low - 1;
}