package com.example.cinek.services;


import com.example.cinek.model.trasa.TrasaPunktowana;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cinek on 29.12.2018.
 */
public interface TrasyService {
    List<TrasaPunktowana> getAllTrasyPuntkowane();
    TrasaPunktowana getTrasaPunktowanaById(Long id);
    void updateTrasaPunktowana(Long id, TrasaPunktowana trasaPunktowana);
    void insertTrasaPunktowana(TrasaPunktowana trasaPunktowana);
    void deleteTrasaPunktowana(Long id);
}
