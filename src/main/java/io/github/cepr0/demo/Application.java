package io.github.cepr0.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import static io.github.cepr0.demo.Gender.FEMALE;
import static io.github.cepr0.demo.Gender.MALE;
import static java.util.Arrays.asList;

@SpringBootApplication
public class Application {

	private final PersonRepo personRepo;
	
	public Application(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener
	public void onReady(ApplicationReadyEvent e) {
		personRepo.saveAll(asList(
				new Person("person1", 20, MALE),
				new Person("person2", 25, FEMALE),
				new Person("person3", 30, MALE)
		));
	}
}
