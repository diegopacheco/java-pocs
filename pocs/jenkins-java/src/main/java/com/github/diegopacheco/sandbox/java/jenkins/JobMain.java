package com.github.diegopacheco.sandbox.java.jenkins;

import java.net.URI;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

public class JobMain {
	
	private static final Logger log = LoggerFactory.getLogger(JobMain.class);
	
	public static void main(String[] args) throws Throwable {
		
		String url  = System.getProperty("jenkins_url", "http://localhost:8080/jenkins");
		String user = System.getProperty("jenkins_user", "");
		String pass = System.getProperty("jenkins_pass", "");
		log.info("Using args: URL [{}] USER [{}] PASS [{}]", url,user,pass);
		
		JenkinsServer jenkins = new JenkinsServer(new URI(url), user, pass);
		Map<String, Job> jobs = jenkins.getJobs();
		log.info("Jobs... ");
		log.info("" + jobs);
		
	}
}
