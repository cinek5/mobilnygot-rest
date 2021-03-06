package com.example.cinek.services.interfaces;


import com.example.cinek.model.trasa.PunktTrasy;

import java.util.List;

/**
 * Created by Cinek on 29.12.2018.
 */

public interface PunktService {
    List<PunktTrasy> getAllPunktyTrasy();

    List<PunktTrasy> getPunktyTrasyByGrupaGorska(String nazwaGrupy);

    List<PunktTrasy> getPoczatkowePunktyTrasyByGrupaGorska(String nazwaGrupy);

    void insertPunktTrasy(PunktTrasy punktTrasy);
}
