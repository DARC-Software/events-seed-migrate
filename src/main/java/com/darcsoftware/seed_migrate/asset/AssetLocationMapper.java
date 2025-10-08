package com.darcsoftware.seed_migrate.asset;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AssetLocationMapper {
    @Insert("""
    INSERT INTO asset_location (id, asset_id, provider, storage_key, public_url, is_primary)
    VALUES (#{id}, #{assetId}, #{provider}, #{storageKey}, #{publicUrl}, #{isPrimary})
    """)
    void insert(AssetLocation loc);
}