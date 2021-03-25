import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lists_7_2 {
    public static void main(String[] args) {
        ArrayList<String> words=new ArrayList<>();
        File file =new File("file");
        try {
            Scanner sc=new Scanner(file);
            while (sc.hasNextLine()){
                String line=sc.nextLine();
                String[] lineWords= line.split("[\\s,.]+");
                words.addAll(Arrays.asList(lineWords));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            }
            catch (IOException e1){
                e.printStackTrace();
            }

        }
        System.out.println(words);
    }
}
