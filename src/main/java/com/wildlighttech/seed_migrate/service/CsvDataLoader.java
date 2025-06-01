package com.wildlighttech.seed_migrate.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.wildlighttech.seed_migrate.event.Event;
import com.wildlighttech.seed_migrate.event.EventMapper;
import com.wildlighttech.seed_migrate.venue.VenueMapper;
import com.wildlighttech.seed_migrate.venue.Venue;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.Instant;
import java.util.List;

@Service
public class CsvDataLoader {

    private final VenueMapper venueMapper;
    private final EventMapper eventMapper;

    public CsvDataLoader(VenueMapper venueMapper, EventMapper eventMapper) {
        this.venueMapper = venueMapper;
        this.eventMapper = eventMapper;
    }

    public void loadAllCsvFiles() {
        // Load and insert Venues
        List<Venue> venues = loadDataFromCsv("data/venues.csv", Venue.class);
        for (Venue venue : venues) {
            venueMapper.insertVenue(venue);
        }
        System.out.println("Venues inserted: " + venues.size());

        List<Event> events = loadDataFromCsv("data/events.csv", Event.class);
        for (Event event: events) {
            System.out.println(event.getStartTime() + ">...........................................");
            eventMapper.insertEvent(event);
        }
        System.out.println("Events inserted: " + events.size());
    }

    private <T> List<T> loadDataFromCsv(String csvPath, Class<T> type) {
        System.out.println("Starting CSV data seeding from " + csvPath + "...");
        try {
            // Load the CSV file from resources
            Reader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(csvPath).getInputStream()));

            // Parse CSV file
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<T> data = csvToBean.parse();
            System.out.println("Parsed " + data.size() + " entries from " + csvPath);
            return data;

        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + csvPath + ": " + e.getMessage());
            return List.of(); // return empty list if something fails
        }
    }
}
