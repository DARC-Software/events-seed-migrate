package com.darcsoftware.seed_migrate.party;

import org.apache.ibatis.annotations.*;

@Mapper
public interface PersonProfileMapper {
    @Insert("""
    INSERT INTO person_profile (party_id, first_name, last_name, stage_name, bio, avatar_url, instagram, tiktok, facebook)
    VALUES (#{partyId}, #{firstName}, #{lastName}, #{stageName}, #{bio}, #{avatarUrl}, #{instagram}, #{tiktok}, #{facebook})
    """)
    void insert(PersonProfile profile);
}