package com.darcsoftware.seed_migrate.asset;

import com.darcsoftware.seed_migrate.common.AssetProvider;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetLocation {
    private Long id;
    private Long assetId;
    private AssetProvider provider;
    private String storageKey;
    private String publicUrl;
    private Boolean isPrimary;
    private LocalDateTime createdAt;
}