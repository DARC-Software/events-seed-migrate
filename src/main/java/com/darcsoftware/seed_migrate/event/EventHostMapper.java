package com.darcsoftware.seed_migrate.event;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventHostMapper {
    @Insert("""
    INSERT INTO event_host (event_id, party_id, role, sort_order)
    VALUES (#{eventId}, #{partyId}, #{role}, #{sortOrder})
    """)
    void insert(EventHost host);
}