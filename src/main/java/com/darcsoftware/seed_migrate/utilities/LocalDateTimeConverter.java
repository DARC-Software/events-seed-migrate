package com.darcsoftware.seed_migrate.utilities;

import com.opencsv.bean.AbstractBeanField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter extends AbstractBeanField<LocalDateTime, String> {
    @Override
    protected LocalDateTime convert(String value) {
        if (value == null || value.isBlank()) return null;
        // Accept either "2025-10-08T18:00:00" or "2025-10-08 18:00:00"
        try {
            return LocalDateTime.parse(value.trim(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (Exception e) {
            return LocalDateTime.parse(value.trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
}
