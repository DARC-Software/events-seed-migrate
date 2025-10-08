package com.darcsoftware.seed_migrate.recur;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventRecurrenceRuleMapper {
    @Insert("""
    INSERT INTO event_recurrence_rule
      (id, event_id, rrule, dtstart_local, dtend_local, offset_minutes, dtstart_utc, dtend_utc, timezone, until_at_local, until_at_utc, count_occurrences)
    VALUES
      (#{id}, #{eventId}, #{rrule}, #{dtstartLocal}, #{dtendLocal}, #{offsetMinutes},#{dtstartUtc}, #{dtendUtc}, #{timezone}, #{untilAtLocal}, #{untilAtUtc}, #{countOccurrences})
    """)
    void insert(EventRecurrenceRule rule);
}