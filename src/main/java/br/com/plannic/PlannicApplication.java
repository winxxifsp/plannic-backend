package br.com.plannic;

import br.com.plannic.service.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlannicApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PlannicApplication.class, args);
	}

}
