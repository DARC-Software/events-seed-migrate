package com.darcsoftware.seed_migrate.room;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    private Long id;
    private Long venueId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}