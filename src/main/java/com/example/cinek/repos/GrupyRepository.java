package com.example.cinek.repos;

import com.example.cinek.model.grupa.GrupaGorska;

import java.util.List;

/**
 * Created by Cinek on 12.01.2019.
 */
public interface GrupyRepository {
    List<GrupaGorska> findAllGrupyGorskie();
    List<GrupaGorska> findGrupyGorskieThatAreAssociatedWithAnyTrasa();
}
