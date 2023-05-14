package org.example.repo.Jdbc;

import org.example.Repository.ArtistRepository;
import org.example.Entity.Artist;
import org.example.Utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcArtistRepository implements ArtistRepository {
    @Override
    public void create(Artist artist) {
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "insert into artists (name) values(?)"
            )){
            pstmt.setString(1,artist.getName());
            pstmt.executeUpdate();
        }catch (  SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Artist findById(int id) throws SQLException {
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

    @Override
    public List<Artist> findByName(String name) throws SQLException {
        List<Artist> artists = new ArrayList<>();

        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM artists WHERE name = ?")) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    int id = rs.getInt("id");
                    String artistName = rs.getString("name");
                    artists.add(new Artist(id, artistName));
                }
            }
        }
        return artists;
    }
}
