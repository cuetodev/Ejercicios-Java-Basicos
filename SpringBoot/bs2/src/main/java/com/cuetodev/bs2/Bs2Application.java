package com.cuetodev.bs2;

import com.cuetodev.bs2.models.Persona;
import com.cuetodev.bs2.models.PersonaService;
import com.cuetodev.bs2.models.PersonaServiceImplemented;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs2Application {
	public static void main(String[] args) {
		SpringApplication.run(Bs2Application.class, args);
	}
}
