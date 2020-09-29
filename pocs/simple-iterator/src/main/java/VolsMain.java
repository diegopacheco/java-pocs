import java.util.Arrays;
import java.util.List;

public class VolsMain {
    public static void main(String[] args) {
        printVols("abc is easy as one two...");
    }
    public static void printVols(String word){
        int position=0;
        List<Character> vols = Arrays.asList('a', 'e', 'i', 'o', 'u');
        while(position<word.length()){
            if (vols.contains(word.charAt(position))){
                System.out.println(word.charAt(position++));
            }
            position++;
        }
    }
}
