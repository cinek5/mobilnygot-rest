package com.example.cinek.repos.hibernate;

import com.example.cinek.model.CustomDbObjects.RankEntry;
import com.example.cinek.repos.RankRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class HibernateRankRepository implements RankRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RankEntry> getRank(List<Long> groupIds, Date startDate, Date endDate)
    {
        TypedQuery<RankEntry> query = entityManager.createQuery(
                "SELECT NEW com.example.cinek.model.CustomDbObjects.RankEntry" +
                        "(tr.id, CONCAT(tr.imie, ' ', SUBSTRING(tr.nazwisko, 1, 1), '.'), " +
                        "SUM(ts.trasa.punktyRegulaminowe))" +
                        "FROM TrasaSkladowa as ts JOIN ts.trasa as t JOIN ts.wedrowka as w JOIN w.turysta as tr " +
                        "WHERE ts.status = 4 " +
                        "AND w.dataWedrowki BETWEEN :startDate AND :endDate " +
                        "AND t.grupaGorska.id IN :groupIds " +
                        "GROUP BY tr " +
                        "ORDER BY SUM(ts.trasa.punktyRegulaminowe) DESC",
                RankEntry.class
        ).setParameter("startDate", startDate).setParameter("endDate", endDate)
                .setParameter("groupIds", groupIds);

        return query.getResultList();
    }

    @Override
    public RankEntry getRankEntryWithNoPoints(Long touristId)
    {
        TypedQuery<RankEntry> query = entityManager.createQuery(
                "SELECT NEW com.example.cinek.model.CustomDbObjects.RankEntry" +
                        "(tr.id, CONCAT(tr.imie, ' ', SUBSTRING(tr.nazwisko, 1, 1), '.'), 0) " +
                        "FROM Turysta as tr " +
                        "WHERE tr.id = :id",
                RankEntry.class
        ).setParameter("id", touristId);

        RankEntry result = query.getSingleResult();
        return result;
    }
}
