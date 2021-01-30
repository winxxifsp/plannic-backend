package br.com.plannic;

import br.com.plannic.service.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlannicApplication {

	private static Logger logger = Logger.getLogger(UsuarioService.class);

	public static void main(String[] args) {
		logger.info("ttttttttttttteste");
		SpringApplication.run(PlannicApplication.class, args);
	}

}
