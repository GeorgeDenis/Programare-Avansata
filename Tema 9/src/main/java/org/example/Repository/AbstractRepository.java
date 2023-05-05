package org.example.Repository;

import org.example.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractRepository<T> {
    public final Class<T> entityType;
    protected AbstractRepository(Class<T> entityType){
        this.entityType = entityType;
    }

    /**
     * Metoda insereaza in baza de date o entitate de un anumit tip
     * @param entity
     */
    public void create(T entity){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Metoda cauta in baza de date o entitate dupa id
     * @param id
     * @return
     */
    public T findById(int id){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        T entity = em.find(entityType,id);
        em.close();
        return entity;
    }

    /**
     * Metoda cauta o entitate dupa un NamedQuery in baza de date
     * @param attributeName
     * @param namedQuery
     * @param attributeValue
     * @return
     */
    public List<T> findByAttribute(String attributeName, String namedQuery,String attributeValue){
        EntityManager em = EntityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<T> query = em.createNamedQuery(namedQuery,entityType);
        query.setParameter(attributeName,"%"+attributeValue+"%");
        return query.getResultList();
    }
}
