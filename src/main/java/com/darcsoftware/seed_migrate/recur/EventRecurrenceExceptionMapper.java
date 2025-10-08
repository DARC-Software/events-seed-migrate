package com.darcsoftware.seed_migrate.recur;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventRecurrenceExceptionMapper {
    @Insert("""
    INSERT INTO event_recurrence_exception (rule_id, exdate_local, exdate_utc)
    VALUES (#{ruleId}, #{exdateLocal}, #{exdateUtc})
    """)
    void insert(EventRecurrenceException ex);
}