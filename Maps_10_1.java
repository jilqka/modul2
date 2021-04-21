import java.util.*;

public class Maps_10_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,String> countryToCapital=new HashMap<>();
        countryToCapital.put("Bulgaria","Sofia");
        countryToCapital.put("Turkey","Istanbul");
        countryToCapital.put("Germany","Munich");
        countryToCapital.put("Austria","Vienna");
        countryToCapital.put("Georgia","Tbilisi");

        int points=0;
        System.out.println("Guess the capital of the following country.");
        List countries= new ArrayList(countryToCapital.keySet());
        Collections.shuffle(countries);
        for (Object country : countries) {
            System.out.println("What is the capital of "+country+"?");
            String capital=sc.nextLine();
            if (capital.equals(countryToCapital.get(country))){
                points++;
            }
            else {
                points--;
            }
        }
        System.out.println("Your points are: "+points);
    }
}
