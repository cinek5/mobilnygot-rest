package com.example.cinek.repos.hibernate;

import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.repos.VerificationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HibernateVerificationRepository implements VerificationRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TrasaSkladowa> getWaitingTracksWithPermissionsTo(Long verId)
    {
        TypedQuery<Przodownik> leaderQuery = entityManager.createQuery(
                "SELECT p FROM Przodownik p WHERE p.id = :id",
                Przodownik.class
        ).setParameter("id", verId);
        List<GrupaGorska> permGroups = leaderQuery.getSingleResult().getAuthorizedGrupy();
        TypedQuery<GrupaGorska> groupsQuery = entityManager.createQuery(
                "SELECT g FROM GrupaGorska g WHERE g IN :groups",
                GrupaGorska.class
        ).setParameter("groups", permGroups);
        List<GrupaGorska> groups = groupsQuery.getResultList();
        TypedQuery<TrasaSkladowa> componentTracksQuery = entityManager.createQuery(
                "SELECT ts FROM TrasaSkladowa ts " +
                        "WHERE ts.status = 2 AND ts.trasa.grupaGorska IN :groups",
                TrasaSkladowa.class
        ).setParameter("groups", groups);
        List<TrasaSkladowa> componentTracks = componentTracksQuery.getResultList();
        return componentTracks;
    }

    @Override
    public void changeStatusForCompoundTrack(Long trackId, Integer statusInt, Long leaderId, Integer points)
    {
        TypedQuery<Przodownik> lq = entityManager.createQuery(
                "SELECT p FROM Przodownik p WHERE p.id = :id",
                Przodownik.class
        ).setParameter("id", leaderId);
        Przodownik leader = lq.getSingleResult();
        Query query = entityManager.createQuery(
                "UPDATE TrasaSkladowa ts SET ts.status = :status, ts.verifyPrzodownik = :leader, " +
                        "ts.trasa.punktyRegulaminowe = :points"
        ).setParameter("status", statusInt).setParameter("leader", leader)
                .setParameter("points", points);
        query.executeUpdate();
    }
}
