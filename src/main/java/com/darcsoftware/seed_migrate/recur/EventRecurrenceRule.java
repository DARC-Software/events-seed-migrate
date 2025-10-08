package com.darcsoftware.seed_migrate.recur;

import com.darcsoftware.seed_migrate.utilities.InstantConverter;
import com.darcsoftware.seed_migrate.utilities.LocalDateTimeConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRecurrenceRule {
    @CsvBindByName(column = "id")
    private Long id;

    @CsvBindByName(column = "event_id")
    private Long eventId;

    @CsvBindByName(column = "rrule")
    private String rrule;

    @CsvCustomBindByName(column = "dtstart_local", converter = LocalDateTimeConverter.class)
    private LocalDateTime dtstartLocal;

    @CsvCustomBindByName(column = "dtend_local", converter = LocalDateTimeConverter.class)
    private LocalDateTime dtendLocal;

    @CsvBindByName(column = "timezone")
    private String timezone;

    @CsvBindByName(column = "offset_minutes")
    private Integer offsetMinutes;

    @CsvCustomBindByName(column = "dtstart_utc", converter = InstantConverter.class)
    private Instant dtstartUtc;

    @CsvCustomBindByName(column = "dtend_utc", converter = InstantConverter.class)
    private Instant dtendUtc;

    @CsvCustomBindByName(column = "until_at_local", converter = LocalDateTimeConverter.class)
    private Instant untilAtLocal;

    @CsvCustomBindByName(column = "until_at_utc", converter = InstantConverter.class)
    private Instant untilAtUtc;

    @CsvBindByName(column = "count_occurrences")
    private Integer countOccurrences;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}