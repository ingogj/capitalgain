package br.com.doggoltda.capitalgain;

import br.com.doggoltda.capitalgain.controllers.CliController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapitalgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalgainApplication.class, args);
		CliController cliController = new CliController();
		System.out.println(cliController.readContentFromStdIn());
	}
}
