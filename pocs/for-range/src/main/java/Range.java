import java.util.Iterator;
import java.util.NoSuchElementException;

class Range implements Iterable<Integer> {

    private int from=0;
    private int to;

    public Range(int to) {
        this.to = to;
        this.from=0;
    }

    public Range(int from,int to) {
        this.from=from;
        this.to = to;
    }

    public static Range of(int to){
        return new Range(to);
    }

    public static Range of(int from,int to){
        return new Range(from,to);
    }

    @Override
    public Iterator<Integer> iterator() {
        final int max = to;
        return new Iterator<Integer>() {

            private int current = from;

            @Override
            public boolean hasNext() {
                return current < max;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return current++;
                } else {
                    throw new NoSuchElementException("Range reached the end");
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Can't remove values from a Range");
            }
        };
    }
}