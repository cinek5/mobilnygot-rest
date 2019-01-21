package com.example.cinek.services.interfaces;

import com.example.cinek.model.DTO.wedrowka.TrasaPunktowanaLite;
import com.example.cinek.model.DTO.wedrowka.WedrowkaLite;

import java.util.List;

/**
 * Created by Cinek on 13.01.2019.
 */
public interface CreateWedrowkaService {
    List<TrasaPunktowanaLite> getTrasyPktLiteStartingInPunkt(Long punktId);
    void createWedrowka(WedrowkaLite wedrowkaLite);
 }
