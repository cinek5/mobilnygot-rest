package com.example.cinek.services.inmemory;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.StaticDb;
import com.example.cinek.services.interfaces.GrupyGorskieService;

import java.util.List;

public class InMemoryGrupyGorskieServiceImpl implements GrupyGorskieService
{
    @Override
    public List<GrupaGorska> getAllGrupyGorskie()
    {
        return StaticDb.grupyGorskie;
    }

    @Override
    public List<GrupaGorska> getGrupyGorskieAssociatedWithAnyTrasa() {
        return null;
    }
}
