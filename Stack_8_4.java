import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Stack_8_4 {
    public static void main(String[] args) {
        PriorityQueue<String> queue1=new PriorityQueue<>(Arrays.asList("George","Jim","John","Blake","Kevin","Micheal"));
        PriorityQueue<String> queue2=new PriorityQueue<>(Arrays.asList("George","Katie","Kevin","Micheal","Ryan"));
        System.out.println("Set1:"+queue1);
        System.out.println("Set2:"+queue2);

        PriorityQueue<String> union =new PriorityQueue<>(queue1);
        union.addAll(queue2);

        PriorityQueue<String> intersection=new PriorityQueue<>(queue1);
        intersection.retainAll(queue2);

        PriorityQueue<String> difference= new PriorityQueue<>(union);
        difference.removeAll(intersection);
        System.out.println("Union of sets"+union);
        System.out.println("Difference of sets"+difference);
        System.out.println("Intersection of sets"+intersection);








    }
}
