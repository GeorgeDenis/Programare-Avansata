package org.example.Repository;

import org.example.Entity.Album;

import java.sql.SQLException;
import java.util.List;

public interface AlbumRepository {
    void create(Album album) throws SQLException;
    Album findById(int id) throws SQLException;
    List<Album> findByName(String name) throws SQLException;
}
