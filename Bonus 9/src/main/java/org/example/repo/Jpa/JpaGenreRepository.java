package org.example.repo.Jpa;

import org.example.Entity.Genre;
import org.example.Utils.EntityManagerFactoryUtil;
import org.example.Repository.GenreRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class JpaGenreRepository implements GenreRepository {
    @Override
    public void create(Genre genre) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Genre findById(int id) throws SQLException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Genre genre = em.find(Genre.class,id);
        em.close();
        return genre;
    }

    @Override
    public List<Genre> findByName(String name) throws SQLException {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName",Genre.class);
        query.setParameter("name","%"+name+"%");
        List<Genre> genres= query.getResultList();
        em.close();
        return genres;
    }
}
