package com.darcsoftware.seed_migrate.event;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventMusicGenre {
    private Long eventId;
    private Long genreId;
}