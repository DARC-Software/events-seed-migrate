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
public class EventRecurrenceException {
    @CsvBindByName(column = "rule_id")
    private Long ruleId;

    @CsvCustomBindByName(column = "exdate_local", converter = LocalDateTimeConverter.class)
    private LocalDateTime exdateLocal;

    @CsvCustomBindByName(column = "exdate_utc", converter = InstantConverter.class)
    private Instant exdateUtc;
}