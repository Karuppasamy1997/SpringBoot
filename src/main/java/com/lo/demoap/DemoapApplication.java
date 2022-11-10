package com.lo.demoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lo.demoap")
public class DemoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoapApplication.class, args);
	}

}
