package com.example.cinek.repos.hibernate;

import com.example.cinek.model.Wedrowka.Wedrowka;
import com.example.cinek.repos.WedrowkaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Cinek on 20.01.2019.
 */
@Repository
public class HibernateWedrowkaRepository implements WedrowkaRepository {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Wedrowka> findAllWedrowka() {
        return null;
    }

    @Override
    public List<Wedrowka> getAllWedrowkaByTurystaId(Long turystaId) {
        return null;
    }

    @Override
    public void insertWedrowka(Wedrowka wedrowka) {
        em.persist(wedrowka);
    }
}
