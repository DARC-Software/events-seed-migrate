package com.darcsoftware.seed_migrate.party;

import org.apache.ibatis.annotations.*;

@Mapper
public interface GroupProfileMapper {
    @Insert("""
    INSERT INTO group_profile (party_id, group_name, bio, avatar_url, instagram, tiktok, facebook)
    VALUES (#{partyId}, #{groupName}, #{bio}, #{avatarUrl}, #{instagram}, #{tiktok}, #{facebook})
    """)
    void insert(GroupProfile profile);
}