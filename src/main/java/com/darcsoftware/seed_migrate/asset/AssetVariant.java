package com.darcsoftware.seed_migrate.asset;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetVariant {
    private Long id;
    private Long assetId;
    private String variantCode;
    private String mimeType;
    private Integer widthPx;
    private Integer heightPx;
    private Long byteSize;
    private String storageKey;
    private String publicUrl;
    private LocalDateTime createdAt;
}