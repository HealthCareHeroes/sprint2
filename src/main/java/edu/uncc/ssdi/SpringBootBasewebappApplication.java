package edu.uncc.ssdi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages={"edu.uncc.ssdi.controllers","edu.uncc.ssdi.dao","edu.uncc.ssdi.service", "edu.uncc.ssdi.repositories","edu.uncc.ssdi.model"})
public class SpringBootBasewebappApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasewebappApplication.class, args);
	}
} // end of class