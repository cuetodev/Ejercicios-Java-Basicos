package com.cuetodev.bs3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Bs3Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs3Application.class, args);
	}

	// Gracias a la etiqueta @PostConstruct nada más instanciarse la clase
	// se ejecuta la función.
	@PostConstruct
	public void ejecutate() {
		System.out.println("Hola desde clase inicial");
	}

	@Bean
	CommandLineRunner segundaClase() {
		return p ->
		{
			System.out.println("Hola desde clase secundaria");
		};
	}

	// El ApplicationArguments recoge los argumentos pasados como parámetros al
	// ejecutar nuestro programa.
	@Bean
	CommandLineRunner terceraClase(ApplicationArguments args) {
		return p ->
		{
			System.out.println("Soy la tercera clase");
			System.out.println("Muestro los argumentos");
			System.out.println(Arrays.toString(args.getSourceArgs()));
		};
	}

}

