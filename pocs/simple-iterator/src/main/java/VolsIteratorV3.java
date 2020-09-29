import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VolsIteratorV3 implements Iterator<Character> {

    private String word;
    private List<Character> vols = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private Iterator<Character> resultIterator = null;
    private boolean firstCall = true;

    public VolsIteratorV3(String word){
        if (null==word || "".equals(word)) throw new IllegalArgumentException("word cannot be null");
        this.word=word.toLowerCase();
    }

    private void initialize(){
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
        if (firstCall) {
            initialize();
            firstCall=false;
        }
        return resultIterator.hasNext();
    }

    @Override
    public Character next() {
        if (firstCall) {
            initialize();
            firstCall=false;
        }
        return resultIterator.next();
    }

    public static void main(String[] args) {
        VolsIteratorV3 vit = new VolsIteratorV3("abc is easy as one two...");
        while (vit.hasNext()){
            System.out.println(vit.next());
        }
    }
}