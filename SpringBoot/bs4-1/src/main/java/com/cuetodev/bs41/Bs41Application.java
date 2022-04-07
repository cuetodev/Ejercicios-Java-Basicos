package com.cuetodev.bs41;

import com.cuetodev.bs41.configuration.AppConfiguration;
import com.cuetodev.bs41.configuration.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties({AppConfiguration.class})
public class Bs41Application {
	public static void main(String[] args) {
		SpringApplication.run(Bs41Application.class, args);
	}
}
