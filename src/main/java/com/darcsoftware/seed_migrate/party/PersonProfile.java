package com.darcsoftware.seed_migrate.party;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonProfile {
    private Long partyId;
    private String firstName;
    private String lastName;
    private String stageName;
    private String bio;
    private String avatarUrl;
    private String instagram;
    private String tiktok;
    private String facebook;
}