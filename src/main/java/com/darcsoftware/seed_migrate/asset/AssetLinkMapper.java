package com.darcsoftware.seed_migrate.asset;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AssetLinkMapper {
    @Insert("""
    INSERT INTO asset_link (id, asset_id, object_type, object_id, relation, sort_order)
    VALUES (#{id}, #{assetId}, #{objectType}, #{objectId}, #{relation}, #{sortOrder})
    """)
    void insert(AssetLink link);
}