package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.GroupList;
import com.example.cinek.model.DTO.Pair;
import com.example.cinek.model.grupa.GrupaGorska;

import java.util.List;

public interface GrupyGorskieService
{
    List<GrupaGorska> getAllGrupyGorskie();
    GroupList getAllGrupyGorskieLite();
    List<GrupaGorska> getGrupyGorskieAssociatedWithAnyTrasa();
}
