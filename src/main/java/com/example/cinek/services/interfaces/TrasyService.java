package com.example.cinek.services.interfaces;


import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Cinek on 29.12.2018.
 */
public interface TrasyService {
    List<TrasaPunktowana> getAllTrasyPuntkowane();
    TrasaPunktowana getTrasaPunktowanaById(Long id);
    void updateTrasaPunktowana(Long id, TrasaPunktowana trasaPunktowana, Date dataModyfikacji);
    void insertTrasaPunktowana(TrasaPunktowana trasaPunktowana);
    void deleteTrasaPunktowana(Long id, Date dataUsuniecia);
    List<TrasaPunktowana> getTrasyStartingInPunkt(Long punktId);
}
