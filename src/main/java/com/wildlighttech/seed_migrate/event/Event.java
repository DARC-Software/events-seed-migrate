package com.wildlighttech.seed_migrate.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
}
