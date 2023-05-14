package org.example.Repository;

import org.example.Entity.Genre;

import java.sql.SQLException;
import java.util.List;

public interface GenreRepository {
    void create(Genre artist);
    Genre findById(int id) throws SQLException;
    List<Genre> findByName(String name) throws SQLException;
}
