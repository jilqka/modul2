import java.util.LinkedList;

public class Lists_7_5 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers=new LinkedList<>();
        for (int i = 1; i <= 5000000; i++) {
            numbers.add(i);
        }
        int a =0;
        for ( int number:numbers) {
            a=number;
        }
        System.out.println(a);
    }
}
