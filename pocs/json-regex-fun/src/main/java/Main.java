import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static void parseIt(String string){
        final String regex = "\"([^\"]+)\":[\"]*([^,^\\}^\"]+)";
        final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("***********");
        // works very well
        final String string = "[{\"name\":\"John Doe\",\"url\":\"http://google.com:80/?\",\"type\":42,\"prod\":false}]";
        parseIt(string);

        System.out.println("***********");
        // dont work well
        final String jsonBig = "{\n" +
                "    \"glossary\": {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        parseIt(jsonBig);
        System.out.println("********************************");

        String[] arr = jsonBig.split(",");
        for(String s: arr){
            System.out.println("key: " + s);
        }

    }
}
