package com.darcsoftware.seed_migrate.utilities;

import com.opencsv.bean.AbstractBeanField;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class InstantConverter extends AbstractBeanField<Instant, String> {
    @Override
    protected Instant convert(String value) {
        if (value == null || value.isBlank()) return null;
        String v = value.trim();
        // If it has Z or an offset, Instant.parse works
        try {
            return Instant.parse(v);
        } catch (Exception e) {
            // If it looks like a LocalDateTime without zone, assume UTC
            LocalDateTime ldt = LocalDateTime.parse(v, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            return ldt.toInstant(ZoneOffset.UTC);
        }
    }
}
