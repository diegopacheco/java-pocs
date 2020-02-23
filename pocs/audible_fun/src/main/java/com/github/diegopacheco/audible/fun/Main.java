package com.github.diegopacheco.audible.fun;

import com.nfl.dm.audible.service.DomainMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired DomainMapper dm;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        app.run(args);
    }
    @Override
    public void run(String... args) throws Exception {

		System.out.println("this is DM: " + dm);

		FromStudent fromStudent = new FromStudent();
		fromStudent.setName("Tom Brady");
		fromStudent.setAge(38);
		fromStudent.setGpa(4.0);

		FromAddress fromAddress = new FromAddress();
		fromAddress.setAddress("10950 Washington Blvd");
		fromAddress.setZip("80232");

		ToStudent toStudent = dm.map(ToStudent.class, fromStudent);
		ToAddress toAddress = dm.map(ToAddress.class, fromAddress);

		System.out.println(toStudent);
		System.out.println(toAddress);

		System.out.println("END +++++++++++++++");
	}
}
