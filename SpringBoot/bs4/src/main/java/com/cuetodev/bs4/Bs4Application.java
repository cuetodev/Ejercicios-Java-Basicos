package com.cuetodev.bs4;

import com.cuetodev.bs4.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfiguration.class)
public class Bs4Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}

}
