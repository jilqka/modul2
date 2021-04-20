import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets_9_1 {
    public static void main(String[] args) throws IOException {
        File file=new File("src/collection.java");
        if (file.exists()){
            countVowelsAndConsonant(file);
        }
        else {
            System.out.println("File does not exist.");
        }
    }

    private static void countVowelsAndConsonant(File file) throws IOException {
        Character[] vowelsArray={'A','E','O','U','I','a','e','o','u','i'};
        Set<Character> vowelsSet=new HashSet<>(Arrays.asList(vowelsArray));
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int c=0;
        int countVowels=0;
        int countConsonant=0;
        while ((c= br.read())!=-1){
            char character=(char) c;
            if (character>'A'&&character<'Z'||character>'a'||character<'z'){
                if (vowelsSet.contains(character)){
                    countVowels++;
                }
                else {
                    countConsonant++;
                }
            }

        }
        System.out.println("Vowels:"+countVowels+",consonant:"+countConsonant);
    }

}
