/**
 * JEP 530: Primitive Types in Patterns, instanceof, and switch (Fourth Preview)
 * Extends pattern matching to primitive types in instanceof, switch, and record patterns.
 * @see <a href="https://openjdk.org/jeps/530">JEP 530</a>
 */
public class PrimitivePatternFeature {
    record RoomConfig(int roomSize, boolean active) {}

    public static void run() {
        System.out.println("Primitive Pattern Matching:");

        System.out.println("  Switch on int:");
        int[] sizes = {1, 2, 30, 500, 7000, 99};
        for (int size : sizes) {
            String result = switch (size) {
                case 1 -> "Toilet";
                case 2 -> "Bedroom";
                case 30 -> "Classroom";
                case int i when i > 100 && i < 1000 -> "Cinema";
                case int i when i > 5000 -> "Stadium";
                case int i -> "Unsupported: " + i;
            };
            System.out.println("    Room size " + size + " -> " + result);
        }

        System.out.println("  Switch on boolean:");
        boolean[] tuneStates = {true, false};
        for (boolean inTune : tuneStates) {
            String response = switch (inTune) {
                case true -> "Ready to play a song.";
                case false -> "Let's take five!";
            };
            System.out.println("    In tune=" + inTune + " -> " + response);
        }

        System.out.println("  Primitive instanceof:");
        int value = 42;
        if (value instanceof byte b) {
            System.out.println("    Value " + value + " fits in a byte: " + b);
        } else {
            System.out.println("    Value " + value + " does not fit in a byte");
        }

        int smallValue = 7;
        if (smallValue instanceof byte b) {
            System.out.println("    Value " + smallValue + " fits in a byte: " + b);
        }
    }
}
