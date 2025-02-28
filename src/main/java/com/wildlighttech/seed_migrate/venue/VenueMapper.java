package com.wildlighttech.seed_migrate.venue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VenueMapper {

    @Insert("INSERT INTO venue (name, address, phoneNumber) SELECT #{name}, #{address}, #{phoneNumber} FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM venues WHERE name = #{name})")
    void insertVenue(Venue venue);
}
