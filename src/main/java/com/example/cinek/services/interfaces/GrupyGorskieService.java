package com.example.cinek.services.interfaces;

import com.example.cinek.model.grupa.GrupaGorska;
import com.example.cinek.model.trasa.TrasaPunktowana;

import java.util.List;

public interface GrupyGorskieService
{
    List<GrupaGorska> getAllGrupyGorskie();
    List<GrupaGorska> getGrupyGorskieAssociatedWithAnyTrasa();
}
