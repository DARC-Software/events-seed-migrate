package com.wildlighttech.seed_migrate.event;

import com.wildlighttech.seed_migrate.venue.Venue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventMapper {

    @Insert("INSERT INTO event (name, startTime, endTime, type, host, room, venueId) SELECT #{name}, #{start_time}, #{end_time}, #{type}, #{host}, #{room}, #{venue_id} FROM event")
    void insertEvent(Event event);
}
