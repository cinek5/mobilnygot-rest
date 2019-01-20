package com.example.cinek.repos.hibernate;

import com.example.cinek.model.DTO.Status;
import com.example.cinek.model.Wedrowka.TrasaSkladowa;
import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaNiepunktowana;
import com.example.cinek.model.uzytkownik.Przodownik;
import com.example.cinek.repos.VerificationRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
    @Transactional
    public void changeStatusForCompoundTrack(Long trackId, Status status, Long leaderId, Integer points)
    {
        TypedQuery<Przodownik> leaderQuery = entityManager.createQuery(
                "SELECT p FROM Przodownik p WHERE p.id = :id",
                Przodownik.class
        ).setParameter("id", leaderId);
        Przodownik leader = leaderQuery.getSingleResult();

        Query updateCtQuery = entityManager.createQuery(
                "UPDATE TrasaSkladowa ts SET ts.status = :status, ts.verifyPrzodownik = :leader " +
                        "WHERE ts.id = :trackId"
        ).setParameter("status", status).setParameter("leader", leader)
                .setParameter("trackId", trackId);

        updateCtQuery.executeUpdate();

        if(status == Status.potwierdzona)
        {
            TypedQuery<Trasa> trackQuery = entityManager.createQuery(
                    "SELECT t FROM TrasaSkladowa ts, Trasa t " +
                            "WHERE ts.id = :id AND ts.trasa = t",
                    Trasa.class)
                    .setParameter("id", trackId);
            Trasa track = trackQuery.getSingleResult();
            if(track instanceof TrasaNiepunktowana)
            {
                Query updateTrackPointsQuery = entityManager.createQuery(
                        "UPDATE Trasa SET punktyRegulaminowe = :points " +
                                "WHERE id = :id")
                        .setParameter("points", points).setParameter("id", track.getId());
                updateTrackPointsQuery.executeUpdate();
            }
        }
    }
}
