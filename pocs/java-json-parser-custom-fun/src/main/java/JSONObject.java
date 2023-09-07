import java.util.HashMap;

class JSONObject {

    private final static char specialChar;
    private final static char commaChar;
    private HashMap<String, String> objects;

    static {
        specialChar = String.valueOf(CONSTANTS.SPECIAL).toCharArray()[0];
        commaChar = String.valueOf(CONSTANTS.COMMA).toCharArray()[0];
    }

    // Constructor if this class
    public JSONObject(String arg) {
        getJSONObjects(arg);
    }

    // Method 1
    // Storing json objects as key value pair in hash map
    public void getJSONObjects(String arg) {

        objects = new HashMap<String, String>();

        if (arg.startsWith(String.valueOf(
                CONSTANTS.CURLY_OPEN_BRACKETS))
                && arg.endsWith(String.valueOf(
                CONSTANTS.CURLY_CLOSE_BRACKETS))) {

            StringBuilder builder = new StringBuilder(arg);
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length() - 1);
            builder = replaceCOMMA(builder);

            for (String objects : builder.toString().split(
                    String.valueOf(CONSTANTS.COMMA))) {

                String[] objectValue = objects.split(
                        String.valueOf(CONSTANTS.COLON), 2);

                if (objectValue.length == 2)
                    this.objects.put(
                            objectValue[0]
                                    .replace("'", "")
                                    .replace("\"", ""),
                            objectValue[1]
                                    .replace("'", "")
                                    .replace("\"", ""));
            }
        }
    }

    // Method 2
    public StringBuilder replaceCOMMA(StringBuilder arg) {
        boolean isJsonArray = false;
        for (int i = 0; i < arg.length(); i++) {
            char a = arg.charAt(i);

            if (isJsonArray) {
                if (String.valueOf(a).compareTo(
                        String.valueOf(CONSTANTS.COMMA))
                        == 0) {
                    arg.setCharAt(i, specialChar);
                }
            }

            if (String.valueOf(a).compareTo(String.valueOf(
                    CONSTANTS.SQUARE_OPEN_BRACKETS))
                    == 0)
                isJsonArray = true;
            if (String.valueOf(a).compareTo(String.valueOf(
                    CONSTANTS.SQUARE_CLOSE_BRACKETS))
                    == 0)
                isJsonArray = false;
        }

        return arg;
    }

    // Method 3
    // Getting json object value by key from hash map
    public String getValue(String key) {
        if (objects != null) {
            return objects.get(key).replace(specialChar, commaChar);
        }
        return null;
    }

    // Method 4
    // Getting json array by key from hash map
    public JSONArray getJSONArray(String key) {
        if (objects != null)
            return new JSONArray(objects.get(key).replace('|', ','));
        return null;
    }
}