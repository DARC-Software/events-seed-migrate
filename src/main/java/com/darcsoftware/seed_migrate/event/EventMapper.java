package com.darcsoftware.seed_migrate.event;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventMapper {
    @Insert("""
    INSERT INTO event (
      id, parent_event_id, venue_id, room_id, title, description, background_url, start_time_local, end_time_local, start_time_utc, end_time_utc, timezone, offset_minutes
    )
    VALUES (
      #{id}, #{parentEventId}, #{venueId}, #{roomId}, #{title}, #{description}, #{backgroundUrl}, #{startTimeLocal}, #{endTimeLocal}, #{startTimeUtc}, #{endTimeUtc}, #{timezone}, #{offsetMinutes}
    )
    """)
    void insert(Event event);
}