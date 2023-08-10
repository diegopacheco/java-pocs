
@TechDebt(
        entries = {
                @Entry(name = "Java version", issue = "The code is not using java 21"),
                @Entry(name = "Maven version", issue = "The code is not using Latest Maven"),
                @Entry(name = "Lack of Testing", issue = "Where are the unit tests?")
        }
)
public class Main {

    public static void main(String args[]) {
        TechDebt techdebt = Main.class.getDeclaredAnnotation(TechDebt.class);
        for (Entry entry : techdebt.entries()) {
            System.out.println("Tech debt: " + entry.issue() + " found by: " + entry.name());
        }
    }

}
