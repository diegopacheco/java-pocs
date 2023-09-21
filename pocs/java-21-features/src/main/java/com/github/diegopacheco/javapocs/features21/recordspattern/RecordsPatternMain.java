package com.github.diegopacheco.javapocs.features21.recordspattern;

public class RecordsPatternMain {

    record Point(int x, int y) {}
    enum Color { RED, GREEN, BLUE }
    record ColoredPoint(Point p, Color c) {}
    record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {}

    static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.c());
        }
    }

    public static void main(String[] args) {
        printUpperLeftColoredPoint(new Rectangle(
                new ColoredPoint(new Point(10,10), Color.BLUE),
                new ColoredPoint(new Point(20,20), Color.RED)));

        record Pair(Object x, Object y) {}
        Pair p = new Pair(42, 42);

        if (p instanceof Pair(String s, String t)) {
            System.out.println(s + ", " + t);
        } else {
            System.out.println("Not a pair of strings");
        }
    }
}
