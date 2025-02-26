package com.wildlighttech.seed_migrate.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.wildlighttech.seed_migrate.venue.VenueMapper;
import com.wildlighttech.seed_migrate.venue.Venue;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class CsvDataLoader {

    private final VenueMapper venueMapper;

    public CsvDataLoader(VenueMapper venueMapper) {
        this.venueMapper = venueMapper;
    }

    public void loadDataFromCsv() {
        System.out.println("Starting CSV data seeding...");
        try {
            // Load the CSV file from resources
            Reader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("data/venues.csv").getInputStream()));

            // Parse CSV file
            CsvToBean<Venue> csvToBean = new CsvToBeanBuilder<Venue>(reader)
                    .withType(Venue.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Venue> venues = csvToBean.parse();

            // Insert data into the database
            for (Venue venue : venues) {
                venueMapper.insertVenue(venue);
            }

            System.out.println("Venues inserted: " + venues.size());

            System.out.println("CSV data seeded successfully!");

        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
