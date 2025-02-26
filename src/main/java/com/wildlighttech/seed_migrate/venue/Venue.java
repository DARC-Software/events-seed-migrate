package com.wildlighttech.seed_migrate.venue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
}
