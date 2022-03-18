package com.estore.api.estoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
<<<<<<< HEAD:copy_heroes_rest_api/team-project-2215-swen-261-04-2-the-reading-room/estore-api/src/main/java/com/estore/api/estoreapi/EstoreApiApplication.java
public class EstoreApiApplication {
=======
public class DataProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DataProjectApplication.class);
	}
>>>>>>> 70cd500ae5d2d8e958721a15f9a42481a18ba0d7:data_project/src/main/java/com/example/data_project/DataProjectApplication.java

	public static void main(String[] args) {
		SpringApplication.run(EstoreApiApplication.class, args);
	}

}
