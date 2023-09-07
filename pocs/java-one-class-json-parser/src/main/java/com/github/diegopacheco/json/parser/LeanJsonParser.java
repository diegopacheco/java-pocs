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
        private HashMap<String, String> objects;

        public JSONObject(String arg) { getJSONObjects(arg); }

        private void getJSONObjects(String arg) {
            arg = arg.replaceAll("\t","").replaceAll("\n","");
            objects = new HashMap<String, String>();
            if (arg.startsWith(String.valueOf('{')) && arg.endsWith(String.valueOf('}'))) {
                StringBuilder builder = replaceCOMMA(new StringBuilder(arg),'[',']');

                for (String objects : builder.toString().split(String.valueOf(','))) {
                    String[] objectValue = objects.split(String.valueOf(':'), 2);
                    if (objectValue.length == 2)
                        this.objects.put(objectValue[0]
                                        .replace("'", "")
                                        .replace("\"", "").trim(),
                                objectValue[1]
                                        .replace("'", "")
                                        .replace("\"", "").trim());
                }
            }
            if (objects.isEmpty()) throw new IllegalStateException("Wrong json! Cannot parse it " + arg);
        }

        public String getValue(String key) {
            if (objects != null && !objects.isEmpty()){
                return (objects.get(key)!=null) ? objects.get(key).replace('|', ',') : null;
            }
            return null;
        }

        public JSONArray getJSONArray(String key) {
            return (objects != null && !objects.isEmpty()) ? new JSONArray(objects.get(key).replace('|', ','))  : null;
        }
    }

    static class JSONArray {
        private ArrayList<String> objects;

        public JSONArray(String arg) {
            getJSONObjects(arg);
        }

        private void getJSONObjects(String arg) {
            objects = new ArrayList<String>();
            if (arg.startsWith(String.valueOf('[')) && arg.endsWith(String.valueOf(']'))) {
                StringBuilder builder = replaceCOMMA(new StringBuilder(arg),'{','}');
                Collections.addAll(objects, builder.toString().split(String.valueOf(',')));
            }
        }

        public String getObject(int index) {
            return  (objects != null) ? objects.get(index).replace('|',',') : null;
        }

        public JSONObject getJSONObject(int index) {
            return (objects != null) ? new JSONObject(objects.get(index).replace('|', ',')) : null;
        }
    }

    private static StringBuilder replaceCOMMA(StringBuilder builder,char open,char close) {
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length() - 1);
        boolean isArray = false;
        for (int i = 0; i < builder.length(); i++) {
            char a = builder.charAt(i);
            if (isArray && a==',') {
                builder.setCharAt(i,'|');
            }
            if (a==open)  isArray = true;
            if (a==close) isArray = false;
        }
        return builder;
    }
}