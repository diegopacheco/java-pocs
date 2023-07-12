import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class SudoPIIDetector {

    private static Set<String> names = new HashSet<>();
    private static ArrayList<Pattern> piiPatterns = new ArrayList<>();

    static {
        // ssn
        piiPatterns.add(Pattern.compile("\\d{3}-\\d{2}-\\d{4}"));
        // email
        piiPatterns.add(Pattern.compile("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}"));
        // phone
        piiPatterns.add(Pattern.compile("^\\([4-6]{1}[0-9]{2}\\)[0-9]{3}-[0-9]{4}$"));
        // zipcode
        piiPatterns.add(Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$"));
        // dob
        piiPatterns.add(Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$"));
        // Names
        readAllNames();
        //
        // add other like: Full name, Home address, Passport number,
        // Driver’s license number, Credit card numbers..
    }

    public static boolean hasPII(String s) {
        for (Pattern p : piiPatterns) {
            if (p.matcher(s).find()) {
                return true;
            }
        }
        if (names.contains(s.trim().toLowerCase())){
            return true;
        }
        return false;
    }

    public static void readAllNames() {
        try {
            FileReader filereader = new FileReader(
                    new File(".").getCanonicalPath() +
                            "/src/main/resources/names.csv"
            );

            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withSkipLines(1)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                for (String cell : row) {
                    names.add(cell.trim().toLowerCase());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
