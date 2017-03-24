
public class test {
    public static void main(String[] args) {
        String course = "08722";
        Object[] a = {Integer.valueOf(1), course, new int[2]};
        Object[] b = new Object[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        
        System.out.println(a.equals(b));
    }
}
