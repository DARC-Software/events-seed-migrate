package com.darcsoftware.seed_migrate.asset;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AssetVariantMapper {
    @Insert("""
    INSERT INTO asset_variant (id, asset_id, variant_code, mime_type, width_px, height_px, byte_size, storage_key, public_url)
    VALUES (#{id}, #{assetId}, #{variantCode}, #{mimeType}, #{widthPx}, #{heightPx}, #{byteSize}, #{storageKey}, #{publicUrl})
    """)
    void insert(AssetVariant v);
}