/**
 * JEP 500: Prepare to Make Final Mean Final
 * Warns about deep reflection mutations of final fields, preparing for future enforcement of immutability.
 * @see <a href="https://openjdk.org/jeps/500">JEP 500</a>
 */
public class FinalFieldReflectionFeature {
    static class Guitar {
        final int numberOfStrings;

        Guitar() {
            numberOfStrings = 6;
        }
    }

    public static void run() {
        System.out.println("Final Field Reflection Feature (JEP 500):");
        Guitar guitar = new Guitar();
        System.out.println("  Original number of strings: " + guitar.numberOfStrings);

        try {
            java.lang.reflect.Field field = Guitar.class.getDeclaredField("numberOfStrings");
            field.setAccessible(true);
            field.set(guitar, 12);
            System.out.println("  After reflection mutation: " + guitar.numberOfStrings);
            System.out.println("  WARNING: Final field was mutated via reflection (JDK 26 warns about this)");
        } catch (Exception e) {
            System.out.println("  Final field mutation blocked: " + e.getMessage());
        }
    }
}
