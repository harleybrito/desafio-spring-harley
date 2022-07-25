package com.harley.desafiospringharley;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.harley.desafiospringharley.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class DesafioSpringHarleyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringHarleyApplication.class, args);
	}

}
