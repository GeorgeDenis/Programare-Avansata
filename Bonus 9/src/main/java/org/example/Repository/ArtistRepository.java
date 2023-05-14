package org.example.Repository;

import org.example.Entity.Artist;

import java.sql.SQLException;
import java.util.List;

public interface ArtistRepository {
    void create(Artist artist);
    Artist findById(int id) throws SQLException;
    List<Artist> findByName(String name) throws SQLException;

}
