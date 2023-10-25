package com.github.diegopacheco.loopspocs.iterable;

import java.util.Iterator;

public class IterableStyle {

    public static void main(String[] args) {
        for(int i : new Range(2,10)){
            System.out.println(i);
        }
    }

    public static class Range implements Iterable<Integer>{

        private Integer current=0;
        private Integer to=0;
        private Integer from=0;

        public Range(int to){
            this.to=to;
        }

        public Range(int from,int to){
            this.from=from;
            this.to=to;
            this.current=this.from;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                @Override
                public boolean hasNext() {
                    return current<=to;
                }
                @Override
                public Integer next() {
                    return current++;
                }
            };
        }
    }

}
