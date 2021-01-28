package br.com.plannic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.plannic.service"})
public class PlannicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannicApplication.class, args);
	}

}
