package com.darcsoftware.seed_migrate.event;

import com.darcsoftware.seed_migrate.venue.Venue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {

    @Insert("INSERT INTO event(name, start_time, end_time, type, host, room, venue_id) VALUES(#{name}, #{startTime, jdbcType=TIMESTAMP}, #{endTime, jdbcType=TIMESTAMP}, #{type}, #{host}, #{room}, #{venueId})")
    void insertEvent(Event event);
}
