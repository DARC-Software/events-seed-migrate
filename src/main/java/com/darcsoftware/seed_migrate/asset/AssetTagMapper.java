package com.darcsoftware.seed_migrate.asset;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AssetTagMapper {
    @Insert("""
    INSERT INTO asset_tag (asset_id, tag)
    VALUES (#{assetId}, #{tag})
    """)
    void insert(AssetTag tag);
}