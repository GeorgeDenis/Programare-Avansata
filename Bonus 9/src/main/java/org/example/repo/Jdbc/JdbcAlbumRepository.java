package org.example.repo.Jdbc;

import org.example.Repository.AlbumRepository;
import org.example.Entity.Album;
import org.example.Entity.Artist;
import org.example.Utils.Database;

import java.sql.*;
import java.util.List;

public class JdbcAlbumRepository implements AlbumRepository {
    public Artist findArtistById(int id) throws SQLException {
        try(Connection connection = Database.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select name from artists where id='" + id + "'")){
            if(rs.next()){
                String name = rs.getString(1);
                return new Artist(id,name);
            }else{
                return null;
            }
        }
    }
    public boolean albumExists(String title) throws SQLException {
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT 1 FROM albums WHERE title = ?")) {
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public void create(Album album) throws SQLException {
        if (!albumExists(album.getTitle())) {
            try (Connection connection = Database.getInstance().getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(
                         "INSERT INTO albums (release_year,title,artist) VALUES (?,?,?)")) {
                pstmt.setInt(1, album.getReleaseYear());
                pstmt.setString(2, album.getTitle());
                pstmt.setInt(3, album.getArtist().getId());
                pstmt.executeUpdate();
//                if (albumExists(album.getTitle())) {
//                    AlbumDAOImpl albumDAO = new AlbumDAOImpl();
//                    int albumId = findAlbumIdByTitle(title);
//                    AlbumGenreDAO albumGenreDAO = new AlbumGenreDAOImpl();
//                    albumGenreDAO.addAlbumGenres(albumId, genresIds);
//                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The album already exists!");
        }
    }

    @Override
    public Album findById(int id) throws SQLException {
        Album album = null;

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "SELECT a.id, a.release_year, a.title, a.artist FROM albums a WHERE a.id = ?"
             )) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (album == null) {
                    int release_year = rs.getInt("release_year");
                    String title = rs.getString("title");
                    int artistId = rs.getInt("artist");
                    album = new Album(id, release_year, title, findArtistById(artistId));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    @Override
    public List<Album> findByName(String name) throws SQLException {
        return null;
    }
}
