package com.darcsoftware.seed_migrate.party;

import com.darcsoftware.seed_migrate.common.PartyType;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Party {
    private Long id;
    private PartyType type;
    private String displayName;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}