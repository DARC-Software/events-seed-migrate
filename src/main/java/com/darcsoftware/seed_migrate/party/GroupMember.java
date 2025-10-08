package com.darcsoftware.seed_migrate.party;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember {
    private Long groupId;
    private Long memberId;
    private String role;
    private Integer sortOrder;
    private LocalDateTime createdAt;
}