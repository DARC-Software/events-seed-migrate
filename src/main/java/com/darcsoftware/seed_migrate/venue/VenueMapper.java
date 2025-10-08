package com.darcsoftware.seed_migrate.venue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VenueMapper {
    @Insert("""
    INSERT INTO venue (id, name, slug, address_line1, address_line2, city, state, zip_code)
    VALUES (#{id}, #{name}, #{slug}, #{addressLine1}, #{addressLine2}, #{city}, #{state}, #{zipCode})
    """)
    void insert(Venue venue);
}
