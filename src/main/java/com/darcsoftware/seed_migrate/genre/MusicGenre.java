package com.darcsoftware.seed_migrate.genre;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MusicGenre {
    private Long id;
    private String code;
    private String label;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}