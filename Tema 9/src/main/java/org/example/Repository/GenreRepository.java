package org.example.Repository;

import org.example.Entity.Genre;
import org.example.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenreRepository extends AbstractRepository<Genre>{
    public GenreRepository(){
        super(Genre.class);
    }
//    public void create(Genre genre){
//        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
//        em.getTransaction().begin();
//        em.persist(genre);
//        em.getTransaction().commit();
//        em.close();
//    }
    public Genre findById(int id){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Genre genre = em.find(Genre.class,id);
        em.close();
        return genre;
    }
    public List<Genre> findByName(String name){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName",Genre.class);
        query.setParameter("name","%"+name+"%");
        List<Genre> genres= query.getResultList();
        em.close();
        return genres;

    }
}
