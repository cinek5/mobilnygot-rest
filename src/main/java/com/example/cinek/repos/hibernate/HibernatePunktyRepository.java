package com.example.cinek.repos.hibernate;

import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.repos.PunktyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Cinek on 09.01.2019.
 */
public class HibernatePunktyRepository implements PunktyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PunktTrasy> findAllPunktyTrasy() {
        List<PunktTrasy> punktyTrasy = entityManager.createQuery("Select punktTrasy from PunktTrasy punktTrasy", PunktTrasy.class
        ).getResultList();
        return punktyTrasy;
    }

    @Override
    public PunktTrasy findPunktTrasyById(Long id) {
        return entityManager.find(PunktTrasy.class, id);
    }

    @Override
    public List<PunktTrasy> findPunktyTrasyByGrupaGorska(String nazwa) {
        List<PunktTrasy> punktyTrasy = entityManager.createQuery("Select punktTrasy from PunktTrasy punktTrasy join punktTrasy.grupaGorska as grupa where grupa.nazwaGrupy = :nazwa", PunktTrasy.class
        ).setParameter("nazwa", nazwa).getResultList();
        return punktyTrasy;
    }
}
