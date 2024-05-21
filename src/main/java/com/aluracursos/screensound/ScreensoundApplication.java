package com.aluracursos.screensound;

import com.aluracursos.screensound.principal.Principal;
import com.aluracursos.screensound.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {
	@Autowired
	private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();
	}
}
