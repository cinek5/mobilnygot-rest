package com.example.cinek.services;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.repos.StaticDb;

import java.util.List;

public class GrupyGorskieServiceImpl implements GrupyGorskieService
{
    @Override
    public List<GrupaGorska> getAllGrupyGorskie()
    {
        return StaticDb.grupyGorskie;
    }
}
