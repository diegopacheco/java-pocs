package com.github.diegopacheco.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class XMLMatcher extends TypeSafeMatcher<String> {

    private final String element;

    private XMLMatcher(String element) {
        this.element = element;
    }

    public static Matcher<String> hasElement(String name) {
        return new XMLMatcher(name);
    }

    @Override
    protected boolean matchesSafely(String xml) {
        Document document = parse(xml);
        return document != null && document.getElementsByTagName(element).getLength() > 0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("XML containing element ").appendValue(element);
    }

    @Override
    protected void describeMismatchSafely(String xml, Description mismatch) {
        mismatch.appendText("element ").appendValue(element).appendText(" was not found");
    }

    private static Document parse(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            return null;
        }
    }
}
