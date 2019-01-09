package com.example.cinek.repos;

import com.example.cinek.model.Wedrowka.Wedrowka;

import java.util.List;

/**
 * Created by Cinek on 09.01.2019.
 */
public interface WedrowkaRepository {
    List<Wedrowka> findAllWedrowka();
    List<Wedrowka> getAllWedrowkaByTurystaId(Long turystaId);
    void insertWedrowka(Wedrowka wedrowka);

}
