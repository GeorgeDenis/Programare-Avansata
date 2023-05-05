package org.example.Repository;

import org.example.AlbumGenreKey;
import org.example.Entity.Album;
import org.example.Entity.AlbumGenre;
import org.example.Entity.Genre;
import org.example.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumGenreRepository {

    /**
     * Metoda insereaza in baza de date o instanta noua de tip AlbumGenre
     * @param albumGenre
     */
    public void create(AlbumGenre albumGenre){
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

    /**
     * Metoda cauta in baza de date o instanta de tip AlbumGenre cu o anumita cheie (albumId,genreId)
     * @param albumId
     * @param genreId
     * @return
     */
    public AlbumGenre findById(Integer albumId, Integer genreId) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        AlbumGenreKey albumGenreId = new AlbumGenreKey(albumId, genreId);
        AlbumGenre albumGenre = em.find(AlbumGenre.class, albumGenreId);
        em.close();
        return albumGenre;
    }

    /**
     * Metoda returneaza o lista de instante de tip AlbumGenre cu toate albumele cu un anumit id
     * @param albumId
     * @return
     */
    public List<AlbumGenre> findByAlbumId(Integer albumId){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<AlbumGenre> query = em.createNamedQuery("AlbumGenre.findByAlbum",AlbumGenre.class);
        query.setParameter("album",albumId);
        return query.getResultList();
    }
    /**
     * Metoda returneaza o lista de instante de tip AlbumGenre cu toate genurile cu un anumit id
     * @param genreId
     * @return
     */
    public List<AlbumGenre> findByGenreId(Integer genreId){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<AlbumGenre> query = em.createNamedQuery("AlbumGenre.findByGenre",AlbumGenre.class);
        query.setParameter("genre",genreId);
        return query.getResultList();
    }



}
