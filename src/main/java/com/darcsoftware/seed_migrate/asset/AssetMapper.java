package com.darcsoftware.seed_migrate.asset;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AssetMapper {
    @Insert("""
    INSERT INTO asset (id, content_sha256, mime_type, byte_size, width_px, height_px, duration_ms)
    VALUES (#{id}, #{contentSha256}, #{mimeType}, #{byteSize}, #{widthPx}, #{heightPx}, #{durationMs})
    """)
    void insert(Asset a);
}