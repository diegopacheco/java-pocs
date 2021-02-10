package com.github.diegopacheco.sandboxspring.controller;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.property.PropertyString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	private static final String FEATURE_SHOW_WEBCONSOLE = "showWebConsoleURL";
	private static final String FEATURE_SHOW_REST_API = "showRestApiURL";
	private static final String FEATURE_SHOW_USERNAME = "showUserName";
	private static final String PROPERTY_USERNAME = "username";

	@Autowired
	public FF4j ff4j;

	@PostConstruct
	public void populateDummyFeatureForMySample() {
		if (!ff4j.exist(FEATURE_SHOW_WEBCONSOLE)) {
			ff4j.createFeature(new Feature(FEATURE_SHOW_WEBCONSOLE, true));
		}
		if (!ff4j.exist(FEATURE_SHOW_REST_API)) {
			ff4j.createFeature(new Feature(FEATURE_SHOW_REST_API, true));
		}
		if (!ff4j.exist(FEATURE_SHOW_USERNAME)) {
			ff4j.createFeature(new Feature(FEATURE_SHOW_USERNAME, true));
		}
		if (!ff4j.getPropertiesStore().existProperty(PROPERTY_USERNAME)) {
			ff4j.createProperty(new PropertyString(PROPERTY_USERNAME, "cedrick"));
		}
		LOGGER.info(" + Features and properties have been created for the sample.");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
	public String get() {
		LOGGER.info(" + Rendering home page...");
		StringBuilder htmlPage = new StringBuilder("<html><body><ul>");
		htmlPage.append("<h2>This is home page.</h2>");
		htmlPage.append("<p>Displaying the links below is driven by features in FF4j."
				+ "If you disable the feature "
				+ "the link will disapear (but the servlet will still response, "
				+ "this is just a trick to illustrate "
				+ "response in the UI)</p>");
		htmlPage.append("<p><b>List of resources for you :"
				+ "</b><br/><ul>");
		if (ff4j.check(FEATURE_SHOW_WEBCONSOLE)) {
			htmlPage.append("<li> To access the  To access the <b>REST API</b> "
					+ "please go to <a href=\"./api/ff4j\" target=\"_blank\">ff4j-rest-api </a>");
		}
		if (ff4j.check(FEATURE_SHOW_USERNAME)) {
			if (ff4j.getPropertiesStore().existProperty(PROPERTY_USERNAME)) {
				htmlPage.append("<li> " + PROPERTY_USERNAME + " value is ");
				htmlPage.append("<span style=\"color:blue;font-weight:bold\">");
				htmlPage.append(ff4j.getPropertiesStore().readProperty(PROPERTY_USERNAME).asString());
				htmlPage.append("</span>");
			} else {
				htmlPage.append("<li> " + PROPERTY_USERNAME + " does not exist.");
			}
		}
		htmlPage.append("</ul></body></html>");
		return htmlPage.toString();
	}

}

