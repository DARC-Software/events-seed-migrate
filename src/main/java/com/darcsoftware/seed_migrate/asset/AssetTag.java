package com.darcsoftware.seed_migrate.asset;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetTag {
    private Long assetId;
    private String tag;
}