package com.github.diegopacheco.json.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LeanJsonParser {
    private static final char CURLY_OPEN_BRACKETS = '{';
    private static final char CURLY_CLOSE_BRACKETS = '}';
    private static final char SQUARE_OPEN_BRACKETS = '[';
    private static final char SQUARE_CLOSE_BRACKETS = ']';
    private static final char COLON = ':';
    private static final char COMMA = ',';
    private static final char SPECIAL = '|';

    public static JSONObject parse(String str){
        if (null==str || str.isEmpty()) throw new IllegalArgumentException("str cannot be null nor empty");
        return new JSONObject(str);
    }

    static class JSONObject {

        private final static char specialChar;
        private final static char commaChar;
        private HashMap<String, String> objects;

        static {
            specialChar = String.valueOf(SPECIAL).toCharArray()[0];
            commaChar = String.valueOf(COMMA).toCharArray()[0];
        }

        public JSONObject(String arg) {
            getJSONObjects(arg);
        }

        private void getJSONObjects(String arg) {
            objects = new HashMap<String, String>();
            if (arg.startsWith(String.valueOf(CURLY_OPEN_BRACKETS)) && arg.endsWith(String.valueOf(CURLY_CLOSE_BRACKETS))) {

                StringBuilder builder = new StringBuilder(arg);
                builder.deleteCharAt(0);
                builder.deleteCharAt(builder.length() - 1);
                builder = replaceCOMMA(builder);

                for (String objects : builder.toString().split(String.valueOf(COMMA))) {
                    String[] objectValue = objects.split(String.valueOf(COLON), 2);
                    if (objectValue.length == 2)
                        this.objects.put(
                                objectValue[0]
                                        .replace("'", "")
                                        .replace("\"", "").trim(),
                                objectValue[1]
                                        .replace("'", "")
                                        .replace("\"", "").trim());
                }
            }
            if (objects.isEmpty()) throw new IllegalStateException("Wrong json! Cannot parse it " + arg);
        }

        private StringBuilder replaceCOMMA(StringBuilder arg) {
            boolean isJsonArray = false;
            for (int i = 0; i < arg.length(); i++) {
                char a = arg.charAt(i);
                if (isJsonArray) {
                    if (String.valueOf(a).compareTo(String.valueOf(COMMA)) == 0) {
                        arg.setCharAt(i, specialChar);
                    }
                }
                if (String.valueOf(a).compareTo(String.valueOf(SQUARE_OPEN_BRACKETS)) == 0)
                    isJsonArray = true;
                if (String.valueOf(a).compareTo(String.valueOf(SQUARE_CLOSE_BRACKETS)) == 0)
                    isJsonArray = false;
            }
            return arg;
        }

        public String getValue(String key) {
            if (objects != null && !objects.isEmpty()){
                String result = objects.get(key);
                return (result!=null) ? result.replace(specialChar, commaChar) : null;
            }
            return null;
        }

        public JSONArray getJSONArray(String key) {
            return (objects != null && !objects.isEmpty()) ? new JSONArray(objects.get(key).replace('|', ','))  : null;
        }
    }

    static class JSONArray {

        private final static char specialChar;
        private final static char commaChar;

        private ArrayList<String> objects;

        static {
            specialChar = String.valueOf(SPECIAL).toCharArray()[0];
            commaChar = String.valueOf(COMMA).toCharArray()[0];
        }

        public JSONArray(String arg) {
            getJSONObjects(arg);
        }

        private void getJSONObjects(String arg) {
            objects = new ArrayList<String>();
            if (arg.startsWith(String.valueOf(SQUARE_OPEN_BRACKETS)) && arg.endsWith(String.valueOf(SQUARE_CLOSE_BRACKETS))) {
                StringBuilder builder = new StringBuilder(arg);
                builder.deleteCharAt(0);
                builder.deleteCharAt(builder.length() - 1);
                builder = replaceCOMMA(builder);
                Collections.addAll(objects, builder.toString().split(String.valueOf(COMMA)));
            }
        }

        private StringBuilder replaceCOMMA(StringBuilder arg) {
            boolean isArray = false;
            for (int i = 0; i < arg.length(); i++) {
                char a = arg.charAt(i);
                if (isArray) {
                    if (String.valueOf(a).compareTo(String.valueOf(COMMA)) == 0) {
                        arg.setCharAt(i, specialChar);
                    }
                }
                if (String.valueOf(a).compareTo(String.valueOf(CURLY_OPEN_BRACKETS)) == 0)
                    isArray = true;
                if (String.valueOf(a).compareTo(String.valueOf(CURLY_CLOSE_BRACKETS)) == 0)
                    isArray = false;
            }
            return arg;
        }

        public String getObject(int index) {
            return  (objects != null) ? objects.get(index).replace(specialChar, commaChar) : null;
        }

        public JSONObject getJSONObject(int index) {
            return (objects != null) ? new JSONObject(objects.get(index).replace('|', ',')) : null;
        }
    }
}