package com.darcsoftware.seed_migrate.utilities;

import com.opencsv.bean.AbstractBeanField;

import java.time.Instant;

public class InstantConverter extends AbstractBeanField<Instant, String> {
    @Override
    protected Instant convert(String value) {
        return Instant.parse(value);  // throws if string is malformed
    }
}
