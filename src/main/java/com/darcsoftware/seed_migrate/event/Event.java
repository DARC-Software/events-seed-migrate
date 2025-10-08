package com.darcsoftware.seed_migrate.event;

import com.darcsoftware.seed_migrate.utilities.InstantConverter;
import com.darcsoftware.seed_migrate.utilities.LocalDateTimeConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @CsvBindByName(column = "id")
    private Long id;

    // nullable
    @CsvBindByName(column = "parent_event_id")
    private Long parentEventId;

    // REQUIRED
    @CsvBindByName(column = "venue_id")
    private Long venueId;

    // nullable
    @CsvBindByName(column = "room_id")
    private Long roomId;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "description")
    private String description;

    @CsvBindByName(column = "background_url")
    private String backgroundUrl;

    // local calendar times (no zone)
    @CsvCustomBindByName(column = "start_time_local", converter = LocalDateTimeConverter.class)
    private LocalDateTime startTimeLocal;

    @CsvCustomBindByName(column = "end_time_local", converter = LocalDateTimeConverter.class)
    private LocalDateTime endTimeLocal;

    // UTC instants
    @CsvCustomBindByName(column = "start_time_utc", converter = InstantConverter.class)
    private Instant startTimeUtc;

    @CsvCustomBindByName(column = "end_time_utc", converter = InstantConverter.class)
    private Instant endTimeUtc;

    @CsvBindByName(column = "timezone")
    private String timezone;

    @CsvBindByName(column = "offset_minutes")
    private Integer offsetMinutes;

    // getters & setters …
}