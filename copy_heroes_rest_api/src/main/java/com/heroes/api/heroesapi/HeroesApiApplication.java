package com.heroes.api.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
<<<<<<< HEAD:copy_heroes_rest_api/src/main/java/com/heroes/api/heroesapi/HeroesApiApplication.java
public class HeroesApiApplication {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DataProjectApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(HeroesApiApplication.class, args);
	}

}
