package com.darcsoftware.seed_migrate.asset;

import com.darcsoftware.seed_migrate.common.AssetObjectType;
import com.darcsoftware.seed_migrate.common.AssetRelation;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetLink {
    private Long id;
    private Long assetId;
    private AssetObjectType objectType;
    private Long objectId;
    private AssetRelation relation;
    private Integer sortOrder;
    private LocalDateTime createdAt;
}