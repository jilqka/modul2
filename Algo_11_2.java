import java.util.LinkedList;
import java.util.Scanner;
public class Algo_11_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String input=sc.nextLine();
        LinkedList<Character> max=new LinkedList<>();
        LinkedList<Character> list=new LinkedList<>();

        for (int i = 0; i <input.length(); i++) {
            list.add(input.charAt(i));
            for (int j = i+1; j <input.length() ; j++) {
                if (input.charAt(j)>list.getLast()){
                    list.add(input.charAt(j));
                }
            }
            if (list.size()>max.size()){
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        for (int i = 0; i <max.size() ; i++) {
            System.out.print(max.get(i)+" ");
        }

    }
}
