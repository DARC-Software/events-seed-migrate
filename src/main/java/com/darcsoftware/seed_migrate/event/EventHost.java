package com.darcsoftware.seed_migrate.event;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventHost {
    private Long eventId;
    private Long partyId;
    private String role;
    private Integer sortOrder;
    private LocalDateTime createdAt;
}