import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Vols simple, functional like implementation (function) it could be an Utils class.
 * */
public class VolsMain {

    public static void main(String[] args) {
        List<Character> vols = getVols("abc is easy as one two...");
        vols.forEach(System.out::println);
    }

    public static List<Character> getVols(String word){
        int position=0;
        List<Character> result = new ArrayList<>();
        List<Character> vols = Arrays.asList('a', 'e', 'i', 'o', 'u');
        while(position<word.length()){
            if (vols.contains(word.charAt(position))){
                result.add(word.charAt(position));
            }
            position++;
        }
        return result;
    }
}
