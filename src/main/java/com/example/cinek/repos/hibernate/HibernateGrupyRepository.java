package com.example.cinek.repos.hibernate;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.GrupaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Cinek on 12.01.2019.
 */

@Repository
public class HibernateGrupaRepository implements GrupaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<GrupaGorska> findAllGrupyGorskie() {
        List<GrupaGorska> grupyGorskie = entityManager.createQuery("Select grupa from GrupaGorska grupa", GrupaGorska.class
        ).getResultList();
        return grupyGorskie;
    }
}
