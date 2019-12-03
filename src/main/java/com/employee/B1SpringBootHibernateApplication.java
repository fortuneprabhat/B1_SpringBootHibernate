package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class B1SpringBootHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(B1SpringBootHibernateApplication.class, args);
	}

}
