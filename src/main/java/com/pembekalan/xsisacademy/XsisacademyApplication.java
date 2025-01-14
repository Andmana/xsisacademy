package com.pembekalan.xsisacademy;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import com.pembekalan.xsisacademy.repository.UserRepository;

@SpringBootApplication
public class XsisacademyApplication {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(XsisacademyApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Category thriller = new Category("Thriller");
			Category novel = new Category("Novel");
			Category horror = new Category("Horror");

			categoryRepository.save(thriller);
			categoryRepository.save(novel);
			categoryRepository.save(horror);

			Faker faker = new Faker(Locale.forLanguageTag("id-ID"));

			for (int i = 0; i < 10 ; i++) {
				User user = new User(faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.address().fullAddress());
				userRepository.save(user);
			}
		};
	}

}
