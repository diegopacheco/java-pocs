import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VolsIteratorV4 implements Iterator<Character> {

    private String word;
    private List<Character> vols = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private int position=0;

    public VolsIteratorV4(String word){
        if (null==word || "".equals(word)) throw new IllegalArgumentException("word cannot be null");
        this.word=word.toLowerCase();
    }

    private class Result{
        int position;
        Character nextVol;
    }

    private Result checkNext(){
        Result result = null;
        int tempPosition = position;
        while(tempPosition<word.length()){
            if (vols.contains(word.charAt(tempPosition))){
                result = new Result();
                result.nextVol = word.charAt(tempPosition);
                result.position = tempPosition +1;
                return result;
            }
            tempPosition++;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return null != checkNext();
    }

    @Override
    public Character next() {
        Result next = checkNext();
        position = next.position;
        return next.nextVol;
    }

    public static void main(String[] args) {
        VolsIteratorV4 vit = new VolsIteratorV4("abc is easy as one two...");
        while (vit.hasNext()){
            System.out.println(vit.next());
        }
    }
}