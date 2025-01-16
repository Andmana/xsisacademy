package com.pembekalan.xsisacademy;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.pembekalan.xsisacademy.entity.Author;
import com.pembekalan.xsisacademy.entity.Book;
import com.pembekalan.xsisacademy.entity.Category;
import com.pembekalan.xsisacademy.entity.Publisher;
import com.pembekalan.xsisacademy.entity.User;
import com.pembekalan.xsisacademy.repository.AuthorRepository;
import com.pembekalan.xsisacademy.repository.BookRepository;
import com.pembekalan.xsisacademy.repository.CategoryRepository;
import com.pembekalan.xsisacademy.repository.PublisherRepository;
import com.pembekalan.xsisacademy.repository.UserRepository;

@SpringBootApplication
public class XsisacademyApplication {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;
	public static void main(String[] args) {
		SpringApplication.run(XsisacademyApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Category thriller = new Category("Thriller");
			Category novel = new Category("Novel");
			Category horror = new Category("Horror");

			thriller = categoryRepository.save(thriller);
			novel = categoryRepository.save(novel);
			horror = categoryRepository.save(horror);

			Faker faker = new Faker(Locale.forLanguageTag("id-ID"));

			
			for (int i = 0; i < 10 ; i++) {
				User user = new User(faker.name().fullName(), faker.phoneNumber().phoneNumber(), faker.address().fullAddress());
				userRepository.save(user);
			}

			for(int i = 0; i < 10; i++){
				Publisher publisher = new Publisher(faker.book().publisher(), faker.address().fullAddress());
				publisherRepository.save(publisher);
			}

			for(int i = 0; i < 10; i++){
				Author author = new Author(faker.name().fullName(), faker.number().numberBetween(1, 101));
				authorRepository.save(author);
			}

			Author author1 = new Author("Kafka", 10);
			Author author2 = new Author("Dazai", 5);
			Author author3 = new Author("William", 4);

			author1 = authorRepository.save(author1);
			author2 = authorRepository.save(author2);
			author3 = authorRepository.save(author3);

			Publisher publisher1 = new Publisher(faker.book().publisher(), faker.address().fullAddress());
			Publisher publisher2 = new Publisher(faker.book().publisher(), faker.address().fullAddress());
			Publisher publisher3 = new Publisher(faker.book().publisher(), faker.address().fullAddress());

			publisher1 = publisherRepository.save(publisher1);
			publisher2 = publisherRepository.save(publisher2);
			publisher3 = publisherRepository.save(publisher3);

			Book book1 = new Book(author1, horror, publisher1, faker.book().title(), faker.lorem().sentence(10), faker.number().numberBetween(1900, 2025));
			Book book2 = new Book(author2, novel, publisher2, faker.book().title(), faker.lorem().sentence(10), faker.number().numberBetween(1900, 2025));
			Book book3 = new Book(author3, horror, publisher3, faker.book().title(), faker.lorem().sentence(10), faker.number().numberBetween(1900, 2025));


			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);



		};
	}

}
