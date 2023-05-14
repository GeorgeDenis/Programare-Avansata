package org.example.repo.Jpa;

import org.example.Repository.ArtistRepository;
import org.example.Entity.Artist;
import org.example.Utils.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaArtistRepository implements ArtistRepository {
    @Override
    public void create(Artist artist) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Artist findById(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Artist artist = em.find(Artist.class, id);
        em.close();
        return artist;
    }

    @Override
    public List<Artist> findByName(String name) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name","%"+name+"%");
        List<Artist> artists = query.getResultList();
        em.close();
        return artists;
    }
}
