import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VolsIterator implements Iterator<Character> {

    private String word;
    private List<Character> vols = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private int position = 0;

    public VolsIterator(String word){
        if (null==word || "".equals(word)) throw new IllegalArgumentException("word cannot be null");
        this.word=word.toLowerCase();
    }

    @Override
    public boolean hasNext() {
        return position < word.length();
    }

    @Override
    public Character next() {
        while(position<word.length()){
            if (vols.contains(word.charAt(position))){
                position++;
                return word.charAt(position-1);
            }
            position++;
        }
        return null;
    }

    public static void main(String[] args) {
        VolsIterator vit = new VolsIterator("abc is easy as one two...");
        while (vit.hasNext()){
            System.out.println(vit.next());
        }
    }
}
