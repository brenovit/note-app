package br.com.friends.noteapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
public class NoteAppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NoteAppApplication.class, args);
	}
}
