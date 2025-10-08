package com.darcsoftware.seed_migrate.grouping;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventGroupEvent {
    private Long groupId;
    private Long eventId;
    private Integer sortOrder;
    private LocalDateTime createdAt;
}