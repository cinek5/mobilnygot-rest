package com.example.cinek.repos.hibernate;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.GrupyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Cinek on 12.01.2019.
 */

@Repository
public class HibernateGrupyRepository implements GrupyRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<GrupaGorska> findAllGrupyGorskie() {
        List<GrupaGorska> grupyGorskie = entityManager.createQuery("Select grupa from GrupaGorska grupa", GrupaGorska.class
        ).getResultList();
        return grupyGorskie;
    }
}
