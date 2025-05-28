package com.wildlighttech.seed_migrate.venue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VenueMapper {

    @Insert("INSERT INTO venue (name, address, phoneNumber) VALUES #{name}, #{address}, #{phoneNumber}")
    void insertVenue(Venue venue);
}
