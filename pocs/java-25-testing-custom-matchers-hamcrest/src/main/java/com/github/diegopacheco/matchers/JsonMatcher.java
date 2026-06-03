package com.github.diegopacheco.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.LinkedHashSet;
import java.util.Set;

public final class JsonMatcher extends TypeSafeMatcher<String> {

    private final String element;

    private JsonMatcher(String element) {
        this.element = element;
    }

    public static Matcher<String> hasElement(String name) {
        return new JsonMatcher(name);
    }

    @Override
    protected boolean matchesSafely(String json) {
        return keys(json).contains(element);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("JSON containing element ").appendValue(element);
    }

    @Override
    protected void describeMismatchSafely(String json, Description mismatch) {
        mismatch.appendText("found elements ").appendValue(keys(json));
    }

    private static Set<String> keys(String json) {
        Set<String> keys = new LinkedHashSet<>();
        if (json == null) {
            return keys;
        }
        int i = 0;
        int length = json.length();
        while (i < length) {
            if (json.charAt(i) != '"') {
                i++;
                continue;
            }
            StringBuilder token = new StringBuilder();
            i++;
            while (i < length) {
                char ch = json.charAt(i);
                if (ch == '\\' && i + 1 < length) {
                    token.append(json.charAt(i + 1));
                    i += 2;
                    continue;
                }
                if (ch == '"') {
                    i++;
                    break;
                }
                token.append(ch);
                i++;
            }
            int next = i;
            while (next < length && Character.isWhitespace(json.charAt(next))) {
                next++;
            }
            if (next < length && json.charAt(next) == ':') {
                keys.add(token.toString());
            }
        }
        return keys;
    }
}
