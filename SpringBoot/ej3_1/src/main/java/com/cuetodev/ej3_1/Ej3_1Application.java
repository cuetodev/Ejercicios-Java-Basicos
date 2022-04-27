package com.cuetodev.ej3_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Ej3_1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej3_1Application.class, args);
	}

}
