package com.github.diegopacheco.proper.oop.media.two;

import org.json.simple.JSONObject;

import java.util.Map;

/**
 *  Cool thing here is that this solution it's immutable.
 *  It's a nice plus. It does need to be this one, it could be mutable.
 *  But is nice that is Immutable...
 *
 *  The result here is that is more like a Decorator.
 */
public class JsonMedia implements Media {

    private final JSONObject obj;

    public JsonMedia() {
        this.obj = new JSONObject();
    }

    @SuppressWarnings("unchecked")
    public JsonMedia(Media media) {
        obj = new JSONObject();
        obj.putAll(media.build());
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, String> build() {
        return new java.util.HashMap<String,String>(obj);
    }

    @Override
    public String toString() {
        return obj.toJSONString();
    }

}
