package com.example.cinek.repos.hibernate;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.TrasyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
        List<TrasaPunktowana> trasaPunktowana = query.setParameter("name", nazwa).getResultList();
        if (trasaPunktowana.isEmpty()) return null;
        else return trasaPunktowana.iterator().next();
    }

    @Override
    public List<TrasaPunktowana> findTrasyPunktowaneStartingAtPunkt(Long punktId) {
        TypedQuery<TrasaPunktowana> query = entityManager.createQuery(
                "SELECT t FROM TrasaPunktowana t  join t.skladowePunktyTrasy as skladowyPunkt WHERE skladowyPunkt.kolejnoscPunktu=1 and skladowyPunkt.punktTrasy.id= :punktId", TrasaPunktowana.class);
        List<TrasaPunktowana> trasyPunktowane = query.setParameter("punktId", punktId).getResultList();
        return trasyPunktowane;
    }

    @Override
    @Transactional
    public void insertTrasa(Trasa trasa) {

        // insert to db if necessary
        trasa.getSkladowePunktyTrasy().stream().forEach(
                skladowyPunkt -> skladowyPunkt.setPunktTrasy(entityManager.merge(skladowyPunkt.getPunktTrasy()))
        );
        trasa.getSkladowePunktyTrasy().stream().forEach(
                skladowyPunktTrasy -> skladowyPunktTrasy.setTrasa(trasa) );


        entityManager.persist(trasa);

    }

    @Override
    public void updateTrasa(Trasa trasa) {
        entityManager.merge(trasa);
    }
}
