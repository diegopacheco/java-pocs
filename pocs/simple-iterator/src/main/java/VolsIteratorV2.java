import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VolsIteratorV2 implements Iterator<Character> {

    private String word;
    private List<Character> vols = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private Iterator<Character> resultIterator = null;

    public VolsIteratorV2(String word){
        if (null==word || "".equals(word)) throw new IllegalArgumentException("word cannot be null");
        this.word=word.toLowerCase();

        int position=0;
        List<Character> result = new ArrayList<>();
        while(position<word.length()){
            if (vols.contains(word.charAt(position))){
                result.add(word.charAt(position));
            }
            position++;
        }
        resultIterator = result.iterator();
    }

    @Override
    public boolean hasNext() {
        return resultIterator.hasNext();
    }

    @Override
    public Character next() {
        return resultIterator.next();
    }

    public static void main(String[] args) {
        VolsIteratorV2 vit = new VolsIteratorV2("abc is easy as one two...");
        while (vit.hasNext()){
            System.out.println(vit.next());
        }
    }
}