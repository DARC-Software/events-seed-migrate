package com.darcsoftware.seed_migrate;

import com.darcsoftware.seed_migrate.service.CsvDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventsSeedMigrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsSeedMigrateApplication.class, args);
	}

	@Bean
	CommandLineRunner seedDatabase(CsvDataLoader csvDataLoader) {
		return args -> {
			csvDataLoader.loadAll();
			System.out.println("Data seeding complete. Shutting down application...");
			System.exit(0); // Gracefully terminate the application
		};
	}
}
