package org.example.repo.Jdbc;

import org.example.Entity.Genre;
import org.example.Repository.GenreRepository;
import org.example.Utils.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreRepository implements GenreRepository {
    @Override
    public void create(Genre genre) {
        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "insert into genres (name) values(?)"
            )){
            pstmt.setString(1,genre.getName());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Genre findById(int id) throws SQLException {
        try(Connection connection = Database.getInstance().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select name from genres where id='" + id + "'"
            )
        ){
            if(rs.next()){
                String name = rs.getString(1);
                return new Genre(id,name);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genre> findByName(String name) throws SQLException {
        List<Genre> genres = new ArrayList<>();

        try(Connection connection = Database.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM genres WHERE name = ?")) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    int id = rs.getInt("id");
                    String genreName = rs.getString("name");
                    genres.add(new Genre(id, genreName));
                }
            }
        }
        return genres;
    }
    }

