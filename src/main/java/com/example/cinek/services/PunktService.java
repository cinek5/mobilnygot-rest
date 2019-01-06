package com.example.cinek.services;


import com.example.cinek.model.trasa.PunktTrasy;
import java.util.List;

/**
 * Created by Cinek on 29.12.2018.
 */

public interface PunktService {
    List<PunktTrasy> getAllPunktyTrasy();
    void insertPunktTrasy(PunktTrasy punktTrasy);
}
