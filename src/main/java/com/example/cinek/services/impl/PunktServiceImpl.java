package com.example.cinek.services.impl;

import com.example.cinek.model.trasa.PunktTrasy;
import com.example.cinek.repos.PunktyRepository;
import com.example.cinek.services.interfaces.PunktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Cinek on 11.01.2019.
 */
@Service
@Transactional
public class PunktServiceImpl implements PunktService {
    @Autowired
    private PunktyRepository punktyRepository;


    @Override
    public List<PunktTrasy> getAllPunktyTrasy() {
        return punktyRepository.findAllPunktyTrasy();
    }

    @Override
    public List<PunktTrasy> getPunktyTrasyByGrupaGorska(String nazwaGrupy) {
        return punktyRepository.findPunktyTrasyByGrupaGorska(nazwaGrupy);
    }

    @Override
    public void insertPunktTrasy(PunktTrasy punktTrasy) {
    }
}
