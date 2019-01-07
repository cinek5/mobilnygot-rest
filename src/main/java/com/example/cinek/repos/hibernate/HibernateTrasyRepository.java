package com.example.cinek.repos.hibernate;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.TrasyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Cinek on 07.01.2019.
 */
@Repository
public class HibernateTrasyRepository implements TrasyRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Trasa findTrasaById(Long id) {
        return entityManager.find(Trasa.class, id);
    }

    @Override
    public List<TrasaPunktowana> findAllTrasyPunktowane() {
        List<TrasaPunktowana> trasyPunktowane = entityManager.createQuery("Select trasaPunktowana from TrasaPunktowana trasaPunktowana", TrasaPunktowana.class
        ).getResultList();
        return trasyPunktowane;
    }

    @Override
    public TrasaPunktowana findTrasaPunktowanaById(Long id) {
        return entityManager.find(TrasaPunktowana.class, id);
    }

    @Override
    public TrasaPunktowana findTrasaPunktowanaByNazwa(String nazwa) {
        TypedQuery<TrasaPunktowana> query = entityManager.createQuery(
                "SELECT t FROM TrasaPunktowana t WHERE t.nazwa = :name", TrasaPunktowana.class);
        return query.setParameter("name", nazwa).getSingleResult();
    }

    @Override
    public void insertTrasa(Trasa trasa) {
            entityManager.persist(trasa);
    }

    @Override
    public void updateTrasa(Trasa trasa) {
        entityManager.merge(trasa);
    }
}