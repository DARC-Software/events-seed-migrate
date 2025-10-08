package com.darcsoftware.seed_migrate.event;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventPrize {
    private Long id;
    private Long eventId;
    private String name;
    private Integer sortOrder;
    private LocalDateTime createdAt;
}