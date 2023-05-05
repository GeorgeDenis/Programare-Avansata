package org.example.Repository;

import org.example.Entity.Album;
import org.example.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository extends AbstractRepository<Album> {
    public AlbumRepository(){
        super(Album.class);
    }

//    public void create(Album album){
//        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
//        em.getTransaction().begin();
//        em.persist(album);
//        em.getTransaction().commit();
//        em.close();
//    }
    public Album findById(int id){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        Album album = em.find(Album.class,id);
        em.close();
        return album;
    }
    public List<Album> findByName(String title){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Album> query = em.createNamedQuery("Album.findByName",Album.class);
        query.setParameter("title","%"+title+"%");
        em.close();
        return query.getResultList();
    }
}
