package com.wildlighttech.seed_migrate.venue;

import com.wildlighttech.seed_migrate.service.CsvDataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VenueSeeder {

    @Bean
    CommandLineRunner seedDatabase(CsvDataLoader venueDataLoader) {
        return args -> {
            venueDataLoader.loadDataFromCsv();
            System.out.println("Data seeding complete. Shutting down application...");
            System.exit(0); // Gracefully terminate the application
        };
    }
}
