package com.darcsoftware.seed_migrate.party;

import org.apache.ibatis.annotations.*;

@Mapper
public interface PartyMapper {
    @Insert("""
    INSERT INTO party (id, type, display_name, slug)
    VALUES (#{id}, #{type}, #{displayName}, #{slug})
    """)
    void insert(Party party);
}