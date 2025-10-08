package com.darcsoftware.seed_migrate.genre;

import org.apache.ibatis.annotations.*;

@Mapper
public interface MusicGenreMapper {
    @Insert("""
    INSERT INTO music_genre (id, code, label)
    VALUES (#{id}, #{code}, #{label})
    """)
    void insert(MusicGenre genre);
}