package org.example.repo.Jpa;

import org.example.Utils.EntityManagerFactoryUtil;
import org.example.Repository.AlbumRepository;
import org.example.Entity.Album;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class JpaAlbumRepository implements AlbumRepository {
    @Override
    public void create(Album album) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Album findById(int id) throws SQLException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Album album = em.find(Album.class,id);
        em.close();
        return album;
    }

    @Override
    public List<Album> findByName(String name) throws SQLException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Album> query = em.createNamedQuery("Album.findByName",Album.class);
        query.setParameter("title","%"+name+"%");
        em.close();
        return query.getResultList();
    }
    public List<Album> findAll() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Album> query = em.createQuery("SELECT a FROM Album a", Album.class);
        query.setMaxResults(30);
        List<Album> albums = query.getResultList();
        em.close();
        return albums;
    }
}
