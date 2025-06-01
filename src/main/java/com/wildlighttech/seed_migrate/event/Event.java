package com.wildlighttech.seed_migrate.event;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
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
    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "start_time")
    @CsvDate(value = "yyyy-MM-dd'T'HH:mm:ssX")
    private Instant startTime;
    @CsvBindByName(column = "end_time")
    @CsvDate(value = "yyyy-MM-dd'T'HH:mm:ssX")
    private Instant endTime;
    @CsvBindByName(column = "type")
    private String type;
    @CsvBindByName(column = "host")
    private String host;
    @CsvBindByName(column = "room")
    private String room;
    @CsvBindByName(column = "venue_id")
    private Long venueId;
}
