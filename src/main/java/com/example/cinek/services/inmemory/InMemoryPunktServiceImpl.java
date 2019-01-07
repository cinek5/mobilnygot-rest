package com.example.cinek.services.inmemory;

import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.PunktService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cinek on 05.01.2019.
 */
@Service
public class InMemoryPunktServiceImpl implements PunktService {
    @Override
    public List<PunktTrasy> getAllPunktyTrasy() {
        return StaticDb.punktyTrasy;
    }

    @Override
    public void insertPunktTrasy(PunktTrasy punktTrasy) {
        punktTrasy.setId(StaticDb.nextIdPunktyTrasy++);
        StaticDb.punktyTrasy.add(punktTrasy);
    }
}
