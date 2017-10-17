package com.qualicorp.layoutmanager.proofconcept.mb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BatchBean {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public String executar() {
		System.out.println("Executando Job do Spring Batch");
		try {
			System.out.println("Inicio da execução ");
			System.out.println("Job: " + job.getName());
			jobLauncher.run(job, new JobParameters());
			System.out.println("Fim da execução ");
		} catch (Exception e) {
			System.out.println("ERRO");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		return "";
	}
}
