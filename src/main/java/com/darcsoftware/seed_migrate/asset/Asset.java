package com.darcsoftware.seed_migrate.asset;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {
    private Long id;
    private String contentSha256;
    private String mimeType;
    private Long byteSize;
    private Integer widthPx;
    private Integer heightPx;
    private Integer durationMs;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}