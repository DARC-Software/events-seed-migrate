package com.darcsoftware.seed_migrate.grouping;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventGroupMapper {
    @Insert("""
    INSERT INTO event_group (name, slug, description)
    VALUES (#{name}, #{slug}, #{description})
    """)
    void insert(EventGroup group);
}