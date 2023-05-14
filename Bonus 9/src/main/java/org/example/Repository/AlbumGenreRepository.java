package org.example.Repository;

import org.example.Entity.Album;
import org.example.Entity.AlbumGenre;

import java.sql.SQLException;
import java.util.List;

public interface AlbumGenreRepository {
    void create(AlbumGenre albumGenre) throws SQLException;
    AlbumGenre findById(Integer albumId, Integer genreId) throws SQLException;
}
