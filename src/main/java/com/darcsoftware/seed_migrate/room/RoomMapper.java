package com.darcsoftware.seed_migrate.room;

import org.apache.ibatis.annotations.*;

@Mapper
public interface RoomMapper {
    @Insert("""
    INSERT INTO room (id, venue_id, name)
    VALUES (#{id}, #{venueId}, #{name})
    """)
    void insert(Room room);
}