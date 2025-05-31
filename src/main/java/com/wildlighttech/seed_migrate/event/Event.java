package com.wildlighttech.seed_migrate.event;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.wildlighttech.seed_migrate.utilities.InstantConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    @CsvBindByName(column = "start_time")
    @CsvCustomBindByName(converter = InstantConverter.class)
    private Instant startTime;
    @CsvBindByName(column = "end_time")
    @CsvCustomBindByName(converter = InstantConverter.class)
    private Instant endTime;
    private String type;
    private String host;
    private String room;
    private Long venueId;
}
