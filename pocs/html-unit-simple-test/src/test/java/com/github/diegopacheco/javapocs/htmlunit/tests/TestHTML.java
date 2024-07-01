package com.github.diegopacheco.javapocs.htmlunit.tests;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlDivision;
import org.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestHTML {

    @Test
    public void testSimple() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://www.htmlunit.org/");
            assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

            final String pageAsXml = page.asXml();
            assertTrue(pageAsXml.contains("<body class=\"topBarDisabled\">"));

            final String pageAsText = page.asNormalizedText();
            assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        }
    }

    @Test
    public void testXPath() throws Exception {
        try (final WebClient webClient = new WebClient()){
            final HtmlPage page = webClient.getPage("https://htmlunit.sourceforge.io/");

            //get list of all divs
            final List<?> divs = page.getByXPath("//div");
            assertNotNull(divs);

            //get div which has a 'id' attribute of 'banner'
            final HtmlDivision div = (HtmlDivision) page.getByXPath("//div[@id='banner']").get(0);
            assertNotNull(div);
            System.out.println(div.toString());
        }
    }

}
