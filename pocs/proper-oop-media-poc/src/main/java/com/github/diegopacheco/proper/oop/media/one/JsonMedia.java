package com.github.diegopacheco.proper.oop.media.one;

import org.json.simple.JSONObject;

/**
 *  Cool thing here is that this solution it's immutable.
 *  It's a nice plus. It does need to be this one, it could be mutable.
 *  But is nice that is Immutable...
 */
public class JsonMedia implements Media{

    private final JSONObject obj;

    public JsonMedia() {
        this.obj = new JSONObject();
    }

    public JsonMedia(JSONObject obj) {
        this.obj = obj;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Media add(String key, String value) {
        this.obj.put(key,value);
        return new JsonMedia(obj);
    }

    @Override
    public String toString() {
        return obj.toJSONString();
    }
}
