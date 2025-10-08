package com.darcsoftware.seed_migrate.event;

import org.apache.ibatis.annotations.*;

@Mapper
public interface EventMusicGenreMapper {
    @Insert("""
    INSERT INTO event_music_genre (event_id, genre_id)
    VALUES (#{eventId}, #{genreId})
  """)
    void insert(EventMusicGenre emg);
}