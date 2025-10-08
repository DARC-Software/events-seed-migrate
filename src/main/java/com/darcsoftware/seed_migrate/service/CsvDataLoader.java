package com.darcsoftware.seed_migrate.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

// --- Domain models & mappers (adjust package names/class names as needed) ---
import com.darcsoftware.seed_migrate.event.Event;
import com.darcsoftware.seed_migrate.event.EventMapper;

import com.darcsoftware.seed_migrate.venue.Venue;
import com.darcsoftware.seed_migrate.venue.VenueMapper;

import com.darcsoftware.seed_migrate.room.Room;
import com.darcsoftware.seed_migrate.room.RoomMapper;

import com.darcsoftware.seed_migrate.party.Party;
import com.darcsoftware.seed_migrate.party.PartyMapper;
import com.darcsoftware.seed_migrate.party.PersonProfile;
import com.darcsoftware.seed_migrate.party.PersonProfileMapper;
import com.darcsoftware.seed_migrate.party.GroupProfile;
import com.darcsoftware.seed_migrate.party.GroupProfileMapper;
import com.darcsoftware.seed_migrate.party.GroupMember;
import com.darcsoftware.seed_migrate.party.GroupMemberMapper;

import com.darcsoftware.seed_migrate.genre.MusicGenre;
import com.darcsoftware.seed_migrate.genre.MusicGenreMapper;

import com.darcsoftware.seed_migrate.event.EventPrize;
import com.darcsoftware.seed_migrate.event.EventPrizeMapper;
import com.darcsoftware.seed_migrate.event.EventMusicGenre;
import com.darcsoftware.seed_migrate.event.EventMusicGenreMapper;
import com.darcsoftware.seed_migrate.event.EventHost;
import com.darcsoftware.seed_migrate.event.EventHostMapper;

import com.darcsoftware.seed_migrate.grouping.EventGroup;
import com.darcsoftware.seed_migrate.grouping.EventGroupMapper;
import com.darcsoftware.seed_migrate.grouping.EventGroupEvent;
import com.darcsoftware.seed_migrate.grouping.EventGroupEventMapper;

import com.darcsoftware.seed_migrate.recur.EventRecurrenceRule;
import com.darcsoftware.seed_migrate.recur.EventRecurrenceRuleMapper;
import com.darcsoftware.seed_migrate.recur.EventRecurrenceException;
import com.darcsoftware.seed_migrate.recur.EventRecurrenceExceptionMapper;

import com.darcsoftware.seed_migrate.asset.Asset;
import com.darcsoftware.seed_migrate.asset.AssetMapper;
import com.darcsoftware.seed_migrate.asset.AssetLocation;
import com.darcsoftware.seed_migrate.asset.AssetLocationMapper;
import com.darcsoftware.seed_migrate.asset.AssetVariant;
import com.darcsoftware.seed_migrate.asset.AssetVariantMapper;
import com.darcsoftware.seed_migrate.asset.AssetLink;
import com.darcsoftware.seed_migrate.asset.AssetLinkMapper;
import com.darcsoftware.seed_migrate.asset.AssetTag;
import com.darcsoftware.seed_migrate.asset.AssetTagMapper;
// ---------------------------------------------------------------------------

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class CsvDataLoader {

    // Inject mappers/services that perform inserts (adjust as needed)
    private final VenueMapper venueMapper;
    private final RoomMapper roomMapper;

    private final PartyMapper partyMapper;
    private final PersonProfileMapper personProfileMapper;
    private final GroupProfileMapper groupProfileMapper;
    private final GroupMemberMapper groupMemberMapper;

    private final MusicGenreMapper musicGenreMapper;

    private final EventMapper eventMapper;
    private final EventPrizeMapper eventPrizeMapper;
    private final EventMusicGenreMapper eventMusicGenreMapper;
    private final EventHostMapper eventHostMapper;

    private final EventGroupMapper eventGroupMapper;
    private final EventGroupEventMapper eventGroupEventMapper;

    private final EventRecurrenceRuleMapper recurrenceRuleMapper;
    private final EventRecurrenceExceptionMapper recurrenceExceptionMapper;

    private final AssetMapper assetMapper;
    private final AssetLocationMapper assetLocationMapper;
    private final AssetVariantMapper assetVariantMapper;
    private final AssetLinkMapper assetLinkMapper;
    private final AssetTagMapper assetTagMapper;

    public CsvDataLoader(
            VenueMapper venueMapper,
            RoomMapper roomMapper,
            PartyMapper partyMapper,
            PersonProfileMapper personProfileMapper,
            GroupProfileMapper groupProfileMapper,
            GroupMemberMapper groupMemberMapper,
            MusicGenreMapper musicGenreMapper,
            EventMapper eventMapper,
            EventPrizeMapper eventPrizeMapper,
            EventMusicGenreMapper eventMusicGenreMapper,
            EventHostMapper eventHostMapper,
            EventGroupMapper eventGroupMapper,
            EventGroupEventMapper eventGroupEventMapper,
            EventRecurrenceRuleMapper recurrenceRuleMapper,
            EventRecurrenceExceptionMapper recurrenceExceptionMapper,
            AssetMapper assetMapper,
            AssetLocationMapper assetLocationMapper,
            AssetVariantMapper assetVariantMapper,
            AssetLinkMapper assetLinkMapper,
            AssetTagMapper assetTagMapper
    ) {
        this.venueMapper = venueMapper;
        this.roomMapper = roomMapper;
        this.partyMapper = partyMapper;
        this.personProfileMapper = personProfileMapper;
        this.groupProfileMapper = groupProfileMapper;
        this.groupMemberMapper = groupMemberMapper;
        this.musicGenreMapper = musicGenreMapper;
        this.eventMapper = eventMapper;
        this.eventPrizeMapper = eventPrizeMapper;
        this.eventMusicGenreMapper = eventMusicGenreMapper;
        this.eventHostMapper = eventHostMapper;
        this.eventGroupMapper = eventGroupMapper;
        this.eventGroupEventMapper = eventGroupEventMapper;
        this.recurrenceRuleMapper = recurrenceRuleMapper;
        this.recurrenceExceptionMapper = recurrenceExceptionMapper;
        this.assetMapper = assetMapper;
        this.assetLocationMapper = assetLocationMapper;
        this.assetVariantMapper = assetVariantMapper;
        this.assetLinkMapper = assetLinkMapper;
        this.assetTagMapper = assetTagMapper;
    }

    /**
     * Entry point to seed everything in a safe FK order.
     * CSVs should live under: src/main/resources/seed/
     */
    public void loadAll() {
        // 1) Core locations
        insertFromCsv("seed/venue.csv", Venue.class, venueMapper::insert);
        insertFromCsv("seed/room.csv", Room.class, roomMapper::insert);

        // 2) Parties & profiles
        insertFromCsv("seed/party.csv", Party.class, partyMapper::insert);
        insertFromCsv("seed/person_profile.csv", PersonProfile.class, personProfileMapper::insert);
        insertFromCsv("seed/group_profile.csv", GroupProfile.class, groupProfileMapper::insert);
        insertFromCsv("seed/group_member.csv", GroupMember.class, groupMemberMapper::insert);

        // 3) Genres
        insertFromCsv("seed/music_genre.csv", MusicGenre.class, musicGenreMapper::insert);

        // 4) Events (depends on venue, room)
        insertFromCsv("seed/event.csv", Event.class, this::normalizeEvent, eventMapper::insert);
        insertFromCsv("seed/event_prize.csv", EventPrize.class, eventPrizeMapper::insert);
        insertFromCsv("seed/event_music_genre.csv", EventMusicGenre.class, eventMusicGenreMapper::insert);
        insertFromCsv("seed/event_host.csv", EventHost.class, eventHostMapper::insert);

        // 5) Grouping
        insertFromCsv("seed/event_group.csv", EventGroup.class, eventGroupMapper::insert);
        insertFromCsv("seed/event_group_event.csv", EventGroupEvent.class, eventGroupEventMapper::insert);

        // 6) Recurrence
        insertFromCsv("seed/event_recurrence_rule.csv", EventRecurrenceRule.class, recurrenceRuleMapper::insert);
        insertFromCsv("seed/event_recurrence_exception.csv", EventRecurrenceException.class, recurrenceExceptionMapper::insert);

        // 7) Assets
        insertFromCsv("seed/asset.csv", Asset.class, assetMapper::insert);
        insertFromCsv("seed/asset_location.csv", AssetLocation.class, assetLocationMapper::insert);
        insertFromCsv("seed/asset_variant.csv", AssetVariant.class, assetVariantMapper::insert);
        insertFromCsv("seed/asset_link.csv", AssetLink.class, assetLinkMapper::insert);
        insertFromCsv("seed/asset_tag.csv", AssetTag.class, assetTagMapper::insert);

        System.out.println("✅ CSV seed finished.");
    }

    // ---------- Generic CSV parsing + inserting ----------

    private interface Inserter<T> {
        void insert(T row);
    }

    private <T> void insertFromCsv(String classpathCsv, Class<T> type, Inserter<T> inserter) {
        List<T> rows = parseCsv(classpathCsv, type);
        int ok = 0, fail = 0;
        for (int i = 0; i < rows.size(); i++) {
            T row = rows.get(i);
            try {
                inserter.insert(row);
                ok++;
            } catch (Exception ex) {
                fail++;
                System.err.printf("CSV row error in %s (row %d): %s%n", classpathCsv, i + 1, ex.getMessage());
            }
        }
        System.out.printf("Loaded %d/%d rows from %s%n", ok, rows.size(), classpathCsv);
    }

    private <T> void insertFromCsv(
            String classpathCsv,
            Class<T> type,
            java.util.function.Consumer<T> normalizer,
            Inserter<T> inserter) {

        List<T> rows = parseCsv(classpathCsv, type);
        int ok = 0, fail = 0;
        for (int i = 0; i < rows.size(); i++) {
            T row = rows.get(i);
            try {
                if (normalizer != null) normalizer.accept(row);
                inserter.insert(row);
                ok++;
            } catch (Exception ex) {
                fail++;
                System.err.printf("CSV row error in %s (row %d): %s%n", classpathCsv, i + 1, ex.getMessage());
            }
        }
        System.out.printf("Loaded %d/%d rows from %s%n", ok, rows.size(), classpathCsv);
    }

    private <T> List<T> parseCsv(String csvPath, Class<T> type) {
        try {
            ClassPathResource res = new ClassPathResource(csvPath);
            try (Reader reader = new BufferedReader(new InputStreamReader(res.getInputStream()))) {
                CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                        .withType(type)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withThrowExceptions(false) // don’t blow up the whole run on one bad row
                        .build();
                List<T> data = csvToBean.parse();
                // If you want row-level errors:
                csvToBean.getCapturedExceptions().forEach(ex ->
                        System.err.printf("CSV row error in %s: %s%n", csvPath, ex.getMessage()));
                return data;
            }
        } catch (Exception e) {
            System.err.println("Error reading CSV file: " + csvPath + ": " + e.getMessage());
            return List.of();
        }
    }

    private static final String DEFAULT_TZ = "America/New_York";

    private void normalizeEvent(Event e) {
        // timezone (required by DB)
        String tz = (e.getTimezone() == null || e.getTimezone().isBlank())
                ? DEFAULT_TZ
                : e.getTimezone();
        e.setTimezone(tz);

        // derive UTC from local if needed
        if (e.getStartTimeUtc() == null && e.getStartTimeLocal() != null) {
            e.setStartTimeUtc(toUtc(e.getStartTimeLocal(), tz));
        }
        if (e.getEndTimeUtc() == null && e.getEndTimeLocal() != null) {
            e.setEndTimeUtc(toUtc(e.getEndTimeLocal(), tz));
        }

        // derive local from UTC if needed
        if (e.getStartTimeLocal() == null && e.getStartTimeUtc() != null) {
            e.setStartTimeLocal(toLocal(e.getStartTimeUtc(), tz));
        }
        if (e.getEndTimeLocal() == null && e.getEndTimeUtc() != null) {
            e.setEndTimeLocal(toLocal(e.getEndTimeUtc(), tz));
        }

        // compute offset_minutes at the local start
        if (e.getOffsetMinutes() == null && e.getStartTimeLocal() != null) {
            e.setOffsetMinutes(offsetMinutesAt(e.getStartTimeLocal(), tz));
        }

        // quick guard on required FK
        if (e.getVenueId() == null) {
            throw new IllegalArgumentException("venue_id is required for event id=" + e.getId());
        }
    }

    private static java.time.Instant toUtc(java.time.LocalDateTime local, String tz) {
        var zone = java.time.ZoneId.of(tz);
        return local.atZone(zone).toInstant();
    }

    private static java.time.LocalDateTime toLocal(java.time.Instant instant, String tz) {
        var zone = java.time.ZoneId.of(tz);
        return java.time.LocalDateTime.ofInstant(instant, zone);
    }

    private static int offsetMinutesAt(java.time.LocalDateTime local, String tz) {
        var zone = java.time.ZoneId.of(tz);
        var zoff = local.atZone(zone).getOffset();
        return zoff.getTotalSeconds() / 60;
    }
}