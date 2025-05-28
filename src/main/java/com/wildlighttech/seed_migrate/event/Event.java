package com.wildlighttech.seed_migrate.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private Date startTime;
    private Date endTime;
    private String type;
    private String host;
    private String room;
    private Long venueId;
}
