package com.darcsoftware.seed_migrate.event;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventPrizeMapper {
    @Insert("""
    INSERT INTO event_prize (id, event_id, name, sort_order)
    VALUES (#{id}, #{eventId}, #{name}, #{sortOrder})
    """)
    void insert(EventPrize prize);
}