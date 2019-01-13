package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.wedrowka.TrasaPunktowanaLite;
import com.example.cinek.model.trasa.TrasaPunktowana;

import java.util.List;

/**
 * Created by Cinek on 13.01.2019.
 */
public interface CreateWedrowkaService {
    List<TrasaPunktowanaLite> getTrasyPktLiteStartingInPunkt(Long punktId);
 }
