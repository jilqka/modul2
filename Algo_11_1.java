import java.util.Scanner;
public class Algo_11_1 {
    public static void main(String[] args) {
        //O(n)- stupkite se uvelichavat do n no nai nakraq konstantata shte se prenebregne i ostava samo n
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first string");
        String s1=sc.nextLine();
        System.out.println("Enter the second string");
        String s2=sc.nextLine();

        int index=-1;
        int counter=0;

        for (int i = 0; i <s1.length() ; i++) {
            if (s1.charAt(i)==s2.charAt(0)&&counter==0){
                index=i;
                counter++;
            }
            else if (s1.charAt(i)==s2.charAt(counter)){
                counter++;
            }
            else if (counter!=0){
                counter=0;
                index=-1;
                i--;
            }
            if (counter==s2.length()){
                break;
            }
        }
        if (counter!=s2.length()){
            index=-1;
            counter=0;
        }
        if(index>-1){
            System.out.println("Matched at index "+index);
        }
        else {
            System.out.println("String2 is not a substring of String1");
        }
        
    }
}
