package com.example.cinek.repos;

import com.example.cinek.model.trasa.PunktTrasy;

import java.util.List;

/**
 * Created by Cinek on 07.01.2019.
 */
public interface PunktyRepository {
    List<PunktTrasy> findAllPunktyTrasy();
    PunktTrasy findPunktTrasyById(Long id);
}
