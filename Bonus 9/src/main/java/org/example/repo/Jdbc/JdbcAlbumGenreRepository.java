package org.example.repo.Jdbc;

import org.example.Entity.Album;
import org.example.Entity.AlbumGenre;
import org.example.Entity.Genre;
import org.example.Repository.AlbumGenreRepository;
import org.example.Utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAlbumGenreRepository implements AlbumGenreRepository {
    @Override
    public void create(AlbumGenre albumGenre) throws SQLException {
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "INSERT INTO album_genre (album_id, genre_id) VALUES (?, ?)")) {
            stmt.setInt(1, albumGenre.getAlbum().getId());
            stmt.setInt(2, albumGenre.getGenre().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public AlbumGenre findById(Integer albumId, Integer genreId) throws SQLException {
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT * FROM album_genre WHERE album_id = ? AND genre_id = ?")) {
            stmt.setInt(1, albumId);
            stmt.setInt(2, genreId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Album album = new Album(rs.getInt("album_id"), rs.getString("album_name"));
                    Genre genre = new Genre(rs.getInt("genre_id"), rs.getString("genre_name"));
                    return new AlbumGenre(album, genre);
                } else {
                    return null;
                }
            }
        }
    }
}
