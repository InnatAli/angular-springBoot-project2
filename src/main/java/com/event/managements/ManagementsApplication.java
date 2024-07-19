
package com.event.managements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.event.managements"})
public class ManagementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementsApplication.class, args);
	}

}

