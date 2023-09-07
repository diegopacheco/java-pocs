package com.github.diegopacheco.json.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LeanJsonParser {
    public static JSONObject parse(String str){
        if (null==str || str.isEmpty()) throw new IllegalArgumentException("str cannot be null nor empty");
        return new JSONObject(str);
    }

    static class JSONObject {
        private final HashMap<String, String> objects = new HashMap<String, String>();

        public JSONObject(String arg) {
            arg = arg.replaceAll("\t","").replaceAll("\n","");
            if (arg.startsWith(String.valueOf('{')) && arg.endsWith(String.valueOf('}'))) {
                StringBuilder builder = replaceCOMMA(new StringBuilder(arg),'[',']');

                for (String objects : builder.toString().split(String.valueOf(','))) {
                    String[] objectValue = objects.split(String.valueOf(':'), 2);
                    if (objectValue.length == 2)
                        this.objects.put(objectValue[0].replace("'", "").replace("\"", "").trim(),
                                         objectValue[1].replace("'", "").replace("\"", "").trim());
                }
            }
            if (objects.isEmpty()) throw new IllegalStateException("Wrong json! Cannot parse it " + arg);
        }

        public String getValue(String key) {
            return (!objects.isEmpty() && objects.get(key)!=null) ? objects.get(key).replace('|', ',') : null;
        }

        public JSONArray getJSONArray(String key) {
            return (!objects.isEmpty()) ? new JSONArray(objects.get(key).replace('|', ','))  : null;
        }
    }

    static class JSONArray {
        private final ArrayList<String> objects = new ArrayList<String>();

        public JSONArray(String arg) {
            if (arg.startsWith(String.valueOf('[')) && arg.endsWith(String.valueOf(']'))) {
                StringBuilder builder = replaceCOMMA(new StringBuilder(arg),'{','}');
                Collections.addAll(objects, builder.toString().split(String.valueOf(',')));
            }
        }

        public String getObject(int index) {
            return objects.get(index).replace('|',',');
        }

        public JSONObject getJSONObject(int index) {
            return new JSONObject(objects.get(index).replace('|', ','));
        }
    }

    private static StringBuilder replaceCOMMA(StringBuilder builder,char open,char close) {
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length() - 1);
        boolean isArray = false;
        for (int i = 0; i < builder.length(); i++) {
            char a = builder.charAt(i);
            if (isArray && a==',') builder.setCharAt(i,'|');
            if (a==open)  isArray = true;
            if (a==close) isArray = false;
        }
        return builder;
    }
}