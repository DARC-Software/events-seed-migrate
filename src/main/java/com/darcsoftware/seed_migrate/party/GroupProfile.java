package com.darcsoftware.seed_migrate.party;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupProfile {
    private Long partyId;
    private String groupName;
    private String bio;
    private String avatarUrl;
    private String instagram;
    private String tiktok;
    private String facebook;
}