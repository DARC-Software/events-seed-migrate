package com.darcsoftware.seed_migrate.party;

import org.apache.ibatis.annotations.*;

@Mapper
public interface GroupMemberMapper {
    @Insert("""
    INSERT INTO group_member (group_id, member_id, role, sort_order)
    VALUES (#{groupId}, #{memberId}, #{role}, #{sortOrder})
  """)
    void insert(GroupMember gm);
}