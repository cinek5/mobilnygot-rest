package com.example.cinek.repos;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;

import java.util.List;

/**
 * Created by Cinek on 06.01.2019.
 */
public interface TrasyRepository {
    Trasa findTrasaById(Long id);
    List<TrasaPunktowana> findAllTrasyPunktowane();
    TrasaPunktowana findTrasaPunktowanaById(Long id);
    TrasaPunktowana findTrasaPunktowanaByNazwa(String nazwa);
    List<TrasaPunktowana> findTrasyPunktowaneStartingAtPunkt(Long punktId);
    void insertTrasa(Trasa trasa);
    void updateTrasa(Trasa trasa);

}
