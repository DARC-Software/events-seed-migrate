package com.darcsoftware.seed_migrate.grouping;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventGroupEventMapper {
    @Insert("""
    INSERT INTO event_group_event (group_id, event_id, sort_order)
    VALUES (#{groupId}, #{eventId}, #{sortOrder})
    """)
    void insert(EventGroupEvent ege);
}