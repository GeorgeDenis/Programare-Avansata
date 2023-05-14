package org.example.repo.Jpa;

import org.example.Entity.Album;
import org.example.Entity.AlbumGenre;
import org.example.Entity.AlbumGenreKey;
import org.example.Entity.Genre;
import org.example.Repository.AlbumGenreRepository;
import org.example.Utils.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class JpaAlbumGenreRepository implements AlbumGenreRepository {
    @Override
    public void create(AlbumGenre albumGenre) throws SQLException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Album mergedAlbum = em.merge(albumGenre.getAlbum());
        albumGenre.setAlbum(mergedAlbum);
        Genre mergedGenre= em.merge(albumGenre.getGenre());
        albumGenre.setGenre(mergedGenre);
        em.persist(albumGenre);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public AlbumGenre findById(Integer albumId, Integer genreId) throws SQLException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        AlbumGenreKey albumGenreId = new AlbumGenreKey(albumId, genreId);
        AlbumGenre albumGenre = em.find(AlbumGenre.class, albumGenreId);
        em.close();
        return albumGenre;
    }
}
