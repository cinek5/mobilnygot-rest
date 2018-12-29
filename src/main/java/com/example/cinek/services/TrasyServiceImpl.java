package com.example.cinek.services;

import com.example.cinek.model.trasa.TrasaPunktowana;
import com.example.cinek.repos.StaticDb;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Cinek on 29.12.2018.
 */
@Service
public class TrasyServiceImpl implements TrasyService {
    @Override
    public List<TrasaPunktowana> getAllTrasyPuntkowane() {
        return StaticDb.trasyPunktowane;
    }

    @Override
    public TrasaPunktowana getTrasaPunktowanaById(Long id) {
       Optional<TrasaPunktowana> trasaPunktowanaOptional = StaticDb.trasyPunktowane.stream()
                .filter(trasa -> trasa.getId().equals(id)).findAny();
       if (trasaPunktowanaOptional.isPresent()) {
           return trasaPunktowanaOptional.get();
       }
       else
       {
           return null;
       }
    }

    @Override
    public void updateTrasaPunktowana(Long id, TrasaPunktowana trasaPunktowana) {
        TrasaPunktowana oldTrasa = getTrasaPunktowanaById(id);
        if (oldTrasa!=null) {
            trasaPunktowana.setPoprzedniaWersjaId(oldTrasa.getId());
            insertTrasaPunktowanaToDb(trasaPunktowana);
            deleteTrasaPunktowana(id);
        }


    }

    @Override
    public void insertTrasaPunktowana(TrasaPunktowana trasaPunktowana) {
        insertTrasaPunktowanaToDb(trasaPunktowana);
    }

    private void insertTrasaPunktowanaToDb(TrasaPunktowana trasaPunktowana)
    {
        trasaPunktowana.setId(new Long(StaticDb.trasyPunktowane.size()+1));
        trasaPunktowana.setDataDodania(new Date());
        StaticDb.trasyPunktowane.add(trasaPunktowana);
    }

    @Override
    public void deleteTrasaPunktowana(Long id) {
        TrasaPunktowana trasaPunktowana = getTrasaPunktowanaById(id);
        if (trasaPunktowana!=null)
        {
            trasaPunktowana.setDataUsuniecia(new Date());
        }
    }
}
